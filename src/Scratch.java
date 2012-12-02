import java.util.List;

import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.TariffLibrary;


public class Scratch {
	
	public static void main(String[] args) {
//		String startTime = "10h4m3s";
//		String endTime = "11h5m4s";
//		
//		String[] start = startTime.split("[h|m|s]");
//		String[] end = endTime.split("[h|m|s]");
//		
//		System.out.println("Start");
//		for (String string : start) {
//			System.out.println(string);
//		}
//		
//		System.out.println("End");
//		for (String string : end) {
//			System.out.println(string);
//		}
		
		List<Customer> c = CentralCustomerDatabase.getInstance().getCustomers();
		TariffLibrary t = CentralTariffDatabase.getInstance();
		
		for (Customer customer : c) {
			System.out.println(customer.getFullName() + " " + customer.getPhoneNumber() + " " + customer.getPricePlan());
			System.out.println(t.tarriffFor(customer).offPeakRate() + " " + t.tarriffFor(customer).peakRate());
		}
		
		
	}
	
}
