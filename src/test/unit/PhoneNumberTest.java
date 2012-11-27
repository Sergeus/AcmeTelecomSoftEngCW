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
		PhoneNumber phone1 = new PhoneNumber("447788991122");
		Assert.assertTrue(phone1.isValid());
	}
}
