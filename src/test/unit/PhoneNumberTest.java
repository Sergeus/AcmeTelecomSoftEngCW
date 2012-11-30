package test.unit;

import org.junit.Test;

import com.acmetelecom.PhoneNumber;

public class PhoneNumberTest {

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class) 
	public void testLenthException() throws NumberFormatException, Exception{
		PhoneNumber p = new PhoneNumber("440000000000000");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class) 
	public void testCountryCodeLenthException() throws NumberFormatException, Exception{
		PhoneNumber p = new PhoneNumber("444", "0000000000");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class) 
	public void testNumberLenthException() throws NumberFormatException, Exception{
		PhoneNumber p = new PhoneNumber("44", "000000000000000");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = NumberFormatException.class) 
	public void testParsingException() throws NumberFormatException, Exception{
		PhoneNumber p = new PhoneNumber("AA0000000000");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = NumberFormatException.class) 
	public void testCountryCodeParsingException() throws NumberFormatException, Exception{
		PhoneNumber p = new PhoneNumber("AA", "0000000000");
	}
	
	@SuppressWarnings("unused")
	@Test(expected = NumberFormatException.class) 
	public void testNumberParsingException() throws NumberFormatException, Exception{
		PhoneNumber p = new PhoneNumber("44", "ABCDEFGHIJ");
	}
	
	@SuppressWarnings("unused")
	@Test 
	public void testSingleArgConstructor() throws NumberFormatException, Exception{
		PhoneNumber p = new PhoneNumber("440000000000");
	}
	
	@SuppressWarnings("unused")
	@Test 
	public void testTwoArgConstructor() throws NumberFormatException, Exception{
		PhoneNumber p = new PhoneNumber("44", "0000000000");
	}
	
}
