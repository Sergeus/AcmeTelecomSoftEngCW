package fit;


import com.acmetelecom.fakes.FakePrinter;

import fit.ColumnFixture;


public class TheCustomerIsBilled extends ColumnFixture {
	public String Customer;

	@Override
	public void reset() {
		Customer = null;
	}
	
	public String Billed() throws Exception {
		SystemUnderTest.billing.createBillFor(Customer);
		return FakePrinter.getResult();
	}
}
