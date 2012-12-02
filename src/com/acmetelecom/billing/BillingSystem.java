package com.acmetelecom.billing;

import com.acmetelecom.MoneyFormatter;
import com.acmetelecom.PhoneNumber;
import com.acmetelecom.calls.Call;
import com.acmetelecom.calls.CallEnd;
import com.acmetelecom.calls.CallEvent;
import com.acmetelecom.calls.CallStart;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.Tariff;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class BillingSystem {

    private List<CallEvent> callLog = new ArrayList<CallEvent>();
    private HashMap<String, String> billList = new HashMap<String, String>();
    
    public BillingSystem() {
		//TODO: Should BillingSystem be a singleton?
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

    public void createCustomerBills() {
        List<Customer> customers = CentralCustomerDatabase.getInstance().getCustomers();
        for (Customer customer : customers) {
            createBillFor(customer);
        }
        //callLog.clear(); //Replaced with clearLog() function
    }

    private void createBillFor(Customer customer) {
        List<CallEvent> customerEvents = new ArrayList<CallEvent>();
        
        //Check all callers are valid customers
        for (CallEvent callEvent : callLog) {
            if (callEvent.getCaller().equals(customer.getPhoneNumber())) {
                customerEvents.add(callEvent);
            }
        }

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

            DaytimePeakPeriod peakPeriod = new DaytimePeakPeriod();
            if (peakPeriod.offPeak(call.startTime()) && peakPeriod.offPeak(call.endTime()) && call.durationSeconds() < 12 * 60 * 60) {
                cost = new BigDecimal(call.durationSeconds()).multiply(tariff.offPeakRate());
            } else {
                cost = new BigDecimal(call.durationSeconds()).multiply(tariff.peakRate());
            }

            cost = cost.setScale(0, RoundingMode.HALF_UP);
            BigDecimal callCost = cost;
            totalBill = totalBill.add(callCost);
            items.add(new LineItem(call, callCost));
        }

        // ADDED OVG
        billList.put(customer.getPhoneNumber(), MoneyFormatter.penceToPounds(totalBill));
        
        new BillGenerator().send(customer, items, MoneyFormatter.penceToPounds(totalBill));
    }
    
    // ADDED OVG
    public String getBillFor(String phoneNumber) {
    	for (String customer : billList.keySet()) {
			if (customer.equals(phoneNumber)) {
				return billList.get(customer);
			}
		}
    	
    	return "Customer not found!";
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
