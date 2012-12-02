package com.acmetelecom.fakes;

import com.acmetelecom.billing.Printer;

public class FakePrinter implements Printer {
	
    private static Printer instance = new FakePrinter();
    private static String result;

    private FakePrinter() {
    }

    public static Printer getInstance() {
        return instance;
    }

	@Override
	public void printHeading(String name, String phoneNumber, String pricePlan) {
		// Do nothing
	}

	@Override
	public void printItem(String time, String callee, String duration,
			String cost) {
		// Do nothing

	}

	@Override
	public void printTotal(String total) {
		result = "Total = " + total;

	}
	
	public static String getResult(){
		return result;
	}

}
