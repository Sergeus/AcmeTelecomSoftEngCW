package test.fit;


import fit.ColumnFixture;


public class TheCustomerIsBilled extends ColumnFixture {
	public String customer;

	@Override
	public void reset() {
		customer = null;
	}
	
	public String Billed() {
		return "Total = " + SystemUnderTest.billing.createBills(customer);
	}
}
