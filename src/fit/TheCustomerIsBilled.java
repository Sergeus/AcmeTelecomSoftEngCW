package fit;


import fit.ColumnFixture;


public class TheCustomerIsBilled extends ColumnFixture {
	public String Customer;

	@Override
	public void reset() {
		Customer = null;
	}
	
	public String Billed() {
		return "Total = " + SystemUnderTest.billing.createBills(Customer);
	}
}
