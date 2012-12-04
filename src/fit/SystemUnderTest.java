package fit;


import com.acmetelecom.billGenerator.BillGenerator;
import com.acmetelecom.billing.BillingSystem;
import com.acmetelecom.fakes.FakePrinter;

/*
 * Unfortunately, FIT forces you to use static (e.g. global) variables to
 * share information between fixtures.  This class holds the objects
 * that we are testing and those that we are using to support the tests
 * in static variables and defines some useful methods.
 */
public class SystemUnderTest {
	public static final BillingSystem billing = new BillingSystem(new BillGenerator(FakePrinter.getInstance()));
	
}
