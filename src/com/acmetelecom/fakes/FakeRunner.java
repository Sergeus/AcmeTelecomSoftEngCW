package com.acmetelecom.fakes;

import com.acmetelecom.billing.BillingSystem;
import com.acmetelecom.billing.DaytimePeakPeriod;

public class FakeRunner {

	BillingSystem billingSystem;

	public FakeRunner() {
		this.billingSystem = new BillingSystem(DaytimePeakPeriod.getInstance());
	}
	
	public void billCall(FakeCall call) {
	
		this.billingSystem.callInitiated(call.getFrom(), call.getTo());
			
		try {
			sleepSeconds(call.getDuration());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.billingSystem.callCompleted(call.getFrom(), call.getTo());
	}
	
	public String createBills(String customer) {
		this.billingSystem.createCustomerBills();
		return this.billingSystem.getBillFor(customer);
	}
	
	private void sleepSeconds(int n) throws InterruptedException {
		Thread.sleep(n * 1000);
	}
	
}
