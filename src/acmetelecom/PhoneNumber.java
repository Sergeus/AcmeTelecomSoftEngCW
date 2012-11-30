package acmetelecom;

/**
 * Harro I am a phone number class.
 */

public class PhoneNumber {
private String number;
private String countrycode;

public PhoneNumber(String number) throws Exception {
	this.number = number;
	this.countrycode = this.number.substring(0, 2);
	if (number.length() != 12 || countrycode.length() != 2) {
		throw new Exception();
	}
}

public String getNumber() {
	return number;
}

public String getCountrycode() {
	return countrycode;
}

public void setNumber(String number) {
	this.number = number;
}

public void setCountrycode(String countrycode) {
	this.countrycode = countrycode;
}

}
