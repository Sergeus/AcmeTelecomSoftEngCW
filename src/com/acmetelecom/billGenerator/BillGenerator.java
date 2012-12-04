package com.acmetelecom.billGenerator;

import java.util.List;

import com.acmetelecom.billing.util.MoneyFormatter;
import com.acmetelecom.customer.Customer;

public class BillGenerator {
	
	private final Printer printer;
	
	public BillGenerator(Printer printer) {
		this.printer = printer;
	}

    public void send(Customer customer, List<LineItemInterface> calls, String totalBill) {

        //Printer printer = HtmlPrinter.getInstance();
        printer.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());
        for (LineItemInterface call : calls) {
            printer.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
        }
        printer.printTotal(totalBill);
    }

}
