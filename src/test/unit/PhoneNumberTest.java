package test.unit;
import acmetelecom.PhoneNumber;

import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberTest {

	/**
	 * Number is 12 digits
	 */
	@Test
	public void testNumberLength() {
		PhoneNumber phone1;
		try {
			phone1 = new PhoneNumber("447788991122");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error: Bad number");
			Assert.assertTrue(false);
		}
	}
}
