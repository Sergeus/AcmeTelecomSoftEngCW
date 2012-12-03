package com.acmetelecom.billing;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.acmetelecom.PhoneNumber;
import com.acmetelecom.lolClass;
import com.acmetelecom.calls.Call;
import com.acmetelecom.calls.CallEnd;
import com.acmetelecom.calls.CallEvent;
import com.acmetelecom.calls.CallStart;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.CustomerDatabase;
import com.acmetelecom.customer.Tariff;
import com.acmetelecom.time.Duration;
import com.acmetelecom.time.Time;
import com.acmetelecom.time.TimeStamp;

import exceptions.CustomerNotFoundException;

public class BillingSystem {

    private List<CallEvent> callLog = new ArrayList<CallEvent>();
    
    private final BillGenerator billGenerator;
    private final CustomerDatabase database = CentralCustomerDatabase.getInstance();
    
    //TODO: Should BillingSystem be a singleton?
    public BillingSystem(BillGenerator billGenerator){
		this.billGenerator = billGenerator;
	}

    @Deprecated
    public void callInitiated(String caller, String callee){
        callLog.add(new CallStart(caller, callee));
    }

    @Deprecated
    public void callCompleted(String caller, String callee){
        callLog.add(new CallEnd(caller, callee));
    }
    
    public void callInitiated(PhoneNumber caller, PhoneNumber callee) {
        callLog.add(new CallStart(caller, callee));
    }

    public void callCompleted(PhoneNumber caller, PhoneNumber callee) {
        callLog.add(new CallEnd(caller, callee));
    }

    public void callInitiated(PhoneNumber caller, PhoneNumber callee, TimeStamp timeStamp) {
        callLog.add(new CallStart(caller, callee, timeStamp));
    }

    public void callCompleted(PhoneNumber caller, PhoneNumber callee, TimeStamp timeStamp) {
        callLog.add(new CallEnd(caller, callee, timeStamp));
    }
    
    public void createCustomerBills() throws Exception {
        List<Customer> customers = database.getCustomers();
        for (Customer customer : customers) {
            createBillFor(customer);
        }
        
        callLog.clear();
    }
    
    public void createBillFor(String customer) throws CustomerNotFoundException {
        List<Customer> customers = database.getCustomers();
        
        for (Customer c : customers) {
			if (customer.equals(c.getPhoneNumber())) {
				createBillFor(c);
				return;
			}
		}
        
        throw new CustomerNotFoundException("Customer " + customer + " does not exist in customer database");
    }

    private void createBillFor(Customer customer){
        List<CallEvent> customerEvents = new ArrayList<CallEvent>();
        
        //Check all callers are valid customers
        for (CallEvent callEvent : callLog) {
            if (callEvent.getCaller().equals(customer.getPhoneNumber())) {
                customerEvents.add(callEvent);
            }
        }

        // Remove all calls that we have processed
        callLog.removeAll(customerEvents);
        
        List<Call> calls = new ArrayList<Call>();

        CallEvent start = null;
        for (CallEvent event : customerEvents) {
            if (event instanceof CallStart) {
                start = event;
            }
            if (event instanceof CallEnd && start != null) {
                calls.add(new Call(start, event));
                start = null;
            }
        }

        BigDecimal totalBill = new BigDecimal(0);
        List<LineItem> items = new ArrayList<LineItem>();

        for (Call call : calls) {

            Tariff tariff = CentralTariffDatabase.getInstance().tarriffFor(customer);

            BigDecimal cost;

            Time peakStart = DaytimePeakPeriod.getPeakStart();
            Time peakEnd = DaytimePeakPeriod.getPeakEnd();
            Time startTime = call.startTime();
            Time endTime = call.endTime();
            
    		long peakSeconds = 0;
    		long offpeakSeconds = 0;
    		
    		if (peakEnd.isBefore(peakStart) || peakEnd.isBefore(startTime)) {
    			System.out.println("Extending peakEnd");
    			peakEnd = new Time(peakEnd.getHour()+24, peakEnd.getMin(), peakEnd.getSecond());
    		}
    		
    		if (peakStart.isBefore(startTime)) {
    			System.out.println("Extending peakStart");
    			peakStart = new Time(peakStart.getHour()+24, peakStart.getMin(), peakStart.getSecond());
    		}
    		
    		if (endTime.isBefore(startTime)) {
    			System.out.println("Extending endTime");
    			endTime = new Time(endTime.getHour()+24, endTime.getMin(), endTime.getSecond());
    		}		
    		
    	
    		SortedSet<lolClass> t = new TreeSet<lolClass>();
    		t.add(new lolClass("start", peakStart));
    		t.add(new lolClass("end", peakEnd));
    		t.add(new lolClass("final", endTime));
    		
    		Time startOfPeriod = startTime;
    		for (lolClass e : t) {
    			if (e.getType() == "final") {
    				
    				if (e.getTime().isBetween(peakStart, peakEnd)) {
    					peakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
    				} else{
    					offpeakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
    				}

    				break;
    			}
    			
    			if (e.getType() == "start") {
    				offpeakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
    			} else {
    				peakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
    			}
    			
    			startOfPeriod = e.getTime();
    		}
            
            cost = new BigDecimal(peakSeconds).multiply(tariff.peakRate()).add(new BigDecimal(offpeakSeconds).multiply(tariff.offPeakRate()));
            
            cost = cost.setScale(0, RoundingMode.HALF_UP);
            BigDecimal callCost = cost;
            totalBill = totalBill.add(callCost);
            items.add(new LineItem(call, callCost));
        }
        
        billGenerator.send(customer, items, MoneyFormatter.penceToPounds(totalBill));
    }
    
    public void clearCallLog() {
    	callLog.clear();
    }

    static class LineItem {
        private Call call;
        private BigDecimal callCost;

        public LineItem(Call call, BigDecimal callCost) {
            this.call = call;
            this.callCost = callCost;
        }

        public String date() {
            return call.date();
        }

        public String callee() {
            return call.callee();
        }

        public String durationMinutes() {
            return "" + call.durationSeconds() / 60 + ":" + String.format("%02d", call.durationSeconds() % 60);
        }

        public BigDecimal cost() {
            return callCost;
        }
    }
}
