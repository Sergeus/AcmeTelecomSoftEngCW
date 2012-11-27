package fit.fakes;

import acmetelecom.BillingSystem;

public class FakeRunner {

	BillingSystem billingSystem;

	public FakeRunner() {
		this.billingSystem = new BillingSystem();
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
		//TODO return this.billingSystem.findTotalBillFor(customer);
		return "placeholder";
	}
	
	private void sleepSeconds(int n) throws InterruptedException {
		Thread.sleep(n * 1000);
	}
	
}
