package com.acmetelecom.calls;

/**
 * Defines the format of a phone number 
 *
 */
public class PhoneNumber {
	
	private Long number;
	private Long countryCode;
	
	public PhoneNumber(String fullNumber){
		this(fullNumber.substring(0, 2), fullNumber.substring(2));
	}

	public PhoneNumber(String countryCode, String number){
	
		// Checks that arguments are right length
		if (number.length() != 10 || countryCode.length() != 2) {
			throw new IllegalArgumentException("Phone number must be 12 digits long and have a country code of length 2.");
		}
		
		// Checks that numbers are indeed numbers
		this.number = Long.parseLong(number);
		this.countryCode = Long.parseLong(countryCode);
	
	}

	public String getNumber() {
		return number.toString();
	}
	
	public String getCountrycode() {
		return countryCode.toString();
	}
	
	@Override
	public String toString() {
		return countryCode.toString() + number.toString();
	}

}
