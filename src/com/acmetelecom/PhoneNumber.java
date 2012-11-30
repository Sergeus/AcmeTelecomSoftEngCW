package com.acmetelecom;

public class PhoneNumber {
	
	private Long number;
	private Long countryCode;
	
	public PhoneNumber(String fullNumber) throws NumberFormatException, Exception{
		this(fullNumber.substring(0, 2), fullNumber.substring(2));
	}

	public PhoneNumber(String countryCode, String number) throws NumberFormatException, Exception{
	
		// Checks that arguments are right length
		if (number.length() != 10 || countryCode.length() != 2) {
			//TODO: Change to proper exception
			throw new Exception();
		}
		
		// Checks that numbers are indeed numbers
		try{
			this.number = Long.parseLong(number);
			this.countryCode = Long.parseLong(countryCode);
		} catch (NumberFormatException e) {
			throw e;
		}
	
	}

	public String getNumber() {
		return number.toString();
	}
	
	public String getCountrycode() {
		return countryCode.toString();
	}

}
