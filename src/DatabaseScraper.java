import java.util.List;

import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.TariffLibrary;


public class DatabaseScraper {
	
	public static void main(String[] args) {
		List<Customer> c = CentralCustomerDatabase.getInstance().getCustomers();
		TariffLibrary t = CentralTariffDatabase.getInstance();
		
		for (Customer customer : c) {
			System.out.println(customer.getFullName() + " " + customer.getPhoneNumber() + " " + customer.getPricePlan());
			System.out.println(t.tarriffFor(customer).offPeakRate() + " " + t.tarriffFor(customer).peakRate());
		}
		
	}
	
}
