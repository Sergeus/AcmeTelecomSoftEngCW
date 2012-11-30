package com.acmetelecom.billing;

import com.acmetelecom.HtmlPrinter;
import com.acmetelecom.MoneyFormatter;
import com.acmetelecom.Printer;
import com.acmetelecom.customer.Customer;

import java.util.List;

public class BillGenerator {

    public void send(Customer customer, List<BillingSystem.LineItem> calls, String totalBill) {

        Printer printer = HtmlPrinter.getInstance();
        printer.printHeading(customer.getFullName(), customer.getPhoneNumber(), customer.getPricePlan());
        for (BillingSystem.LineItem call : calls) {
            printer.printItem(call.date(), call.callee(), call.durationMinutes(), MoneyFormatter.penceToPounds(call.cost()));
        }
        printer.printTotal(totalBill);
    }

}
