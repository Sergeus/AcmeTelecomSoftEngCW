import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.joda.time.Period;

import com.acmetelecom.customer.CentralCustomerDatabase;
import com.acmetelecom.customer.CentralTariffDatabase;
import com.acmetelecom.customer.Customer;
import com.acmetelecom.customer.TariffLibrary;
import com.acmetelecom.time.Duration;
import com.acmetelecom.time.Time;
import com.acmetelecom.time.TimeStamp;


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
		
		
		
		
//		List<Customer> c = CentralCustomerDatabase.getInstance().getCustomers();
//		TariffLibrary t = CentralTariffDatabase.getInstance();
//		
//		for (Customer customer : c) {
//			System.out.println(customer.getFullName() + " " + customer.getPhoneNumber() + " " + customer.getPricePlan());
//			System.out.println(t.tarriffFor(customer).offPeakRate() + " " + t.tarriffFor(customer).peakRate());
//		}

		
		
		
		
		Time peakStart = new Time(7, 0, 0);
		Time peakEnd = new Time(8, 0, 0);
		
		Time startTime = new TimeStamp(1970, 1, 1, 6, 45, 0).getTime();
		Time endTime = new TimeStamp(1970, 1, 1, 7, 15, 0).getTime();
		
		long peakSeconds = 0;
		long offpeakSeconds = 0;
		
		if (endTime.isBefore(startTime)) {
			endTime = new Time(endTime.getHour()+24, endTime.getMin(), endTime.getSecond());
		}
		
		SortedSet<Time> set = new TreeSet<Time>();
				
		
	}
	
	
	
}
