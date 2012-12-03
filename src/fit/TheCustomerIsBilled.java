package fit;


import com.acmetelecom.exceptions.CustomerNotFoundException;
import com.acmetelecom.fakes.FakePrinter;

import fit.ColumnFixture;


public class TheCustomerIsBilled extends ColumnFixture {
	public String Customer;

	@Override
	public void reset() {
		Customer = null;
	}
	
	public String Billed() throws CustomerNotFoundException {
		SystemUnderTest.billing.createBillFor(Customer);
		return FakePrinter.getResult();
	}
}
