package com.acmetelecom;

import com.acmetelecom.billing.BillGenerator;
import com.acmetelecom.billing.BillingSystem;
import com.acmetelecom.billing.DaytimePeakPeriod;
import com.acmetelecom.billing.HtmlPrinter;
import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CustomerDatabase;

public class Runner {
	
	private static final DaytimePeakPeriod peakPeriod = DaytimePeakPeriod.getInstance();
	private static final BillGenerator billGenerator = new BillGenerator(HtmlPrinter.getInstance());
	private static final CustomerDatabase databse = CentralCustomerDatabase.getInstance();
	
	public static void main(String[] args) throws Exception {
		System.out.println("Running...");
		BillingSystem billingSystem = new BillingSystem(billGenerator);
		
		billingSystem.callInitiated("447722113434", "447766511332");
		sleepSeconds(20);
		billingSystem.callCompleted("447722113434", "447766511332");
		billingSystem.callInitiated("447722113434", "447711111111");
		sleepSeconds(30);
		billingSystem.callCompleted("447722113434", "447711111111");
		billingSystem.callInitiated("447777765432", "447711111111");
		sleepSeconds(60);
		billingSystem.callCompleted("447777765432", "447711111111");
		billingSystem.createCustomerBills();
	}
	
	private static void sleepSeconds(int n) throws InterruptedException {
		Thread.sleep(n * 1000);
	}
	
}