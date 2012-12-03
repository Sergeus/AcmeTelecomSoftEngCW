import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

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

		
		
		
		
		Time peakStart = new Time(7, 00, 00);
		Time peakEnd = new Time(19, 00, 00);
		
		Time startTime = new TimeStamp(2000, 1, 1, 18, 30, 00).getTime();
		Time endTime = new TimeStamp(2000, 1, 2, 01, 00, 00).getTime();
		
		long peakSeconds = 0;
		long offpeakSeconds = 0;
		
		if (peakEnd.isBefore(peakStart) || peakEnd.isBefore(startTime)) {
			System.out.println("Extending peakEnd");
			peakEnd = new Time(peakEnd.getHour()+24, peakEnd.getMin(), peakEnd.getSecond());
		}
		
		if (peakStart.isBefore(startTime)) {
			System.out.println("Extending peakStart");
			peakStart = new Time(peakStart.getHour()+24, peakStart.getMin(), peakStart.getSecond());
		}
		
		if (endTime.isBefore(startTime)) {
			System.out.println("Extending endTime");
			endTime = new Time(endTime.getHour()+24, endTime.getMin(), endTime.getSecond());
		}		
		
	
		SortedSet<lolClass> t = new TreeSet<Scratch.lolClass>();
		t.add(new lolClass("start", peakStart));
		t.add(new lolClass("end", peakEnd));
		t.add(new lolClass("final", endTime));
		
		int i = 0;
		for (lolClass e : t) {
			System.out.println(i++ + " " + e.getType() + " " + e.getTime());
		}
		
		System.out.println("startTime: " + startTime + ". endTime: " + endTime);
		
		Time startOfPeriod = startTime;
		for (lolClass e : t) {
			if (e.getType() == "final") {
				
				if (e.getTime().isBetween(peakStart, peakEnd)) {
					peakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
				} else{
					offpeakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
				}

				break;
			}
			
			if (e.getType() == "start") {
				offpeakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
			} else {
				peakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
			}
			
			startOfPeriod = e.getTime();
		}
		
//		if (endTime.isBefore(t.first().getTime())) {
//			
//			System.out.println("A");
//			
//			if (t.first().getType() == "start") {
//				offpeakSeconds += Duration.inSeconds(startTime, endTime);
//			} else {
//				peakSeconds += Duration.inSeconds(startTime, endTime);
//			}
//			
//		} else {
//			
//			Time startOfPeriod = startTime;
//			Time endOfPeriod;
//			
//			//TODO Is this correct?
//			String lastType = t.first().getType();
//			
//			for (lolClass e : t) {
//				endOfPeriod = e.getTime();
//				
//				if (endTime.isBefore(endOfPeriod) || endTime.isEqual(endOfPeriod)) {
//					
//					System.out.println("B");
//					
//					if (e.getType() == "start" || (e.getType() == "final" && lastType == "end")) {
//						offpeakSeconds += Duration.inSeconds(startOfPeriod, endTime);
//					} else if (e.getType() == "end"  || (e.getType() == "final" && lastType == "start")) {
//						peakSeconds += Duration.inSeconds(startOfPeriod, endTime);
//					}
//					
//					break;
//					
//				} else {
//					
//					System.out.println("C");
//					
//					if (e.getType() == "start") {
//						offpeakSeconds += Duration.inSeconds(startOfPeriod, endOfPeriod);
//					} else {
//						peakSeconds += Duration.inSeconds(startOfPeriod, endOfPeriod);
//					}
//					
//				}
//				
//				startOfPeriod = endOfPeriod;
//				lastType = e.getType();
//			}
//			
//		}
		
		System.out.println("peak seconds: " + peakSeconds + ". off-peak seconds: " + offpeakSeconds);
		
	}
	
	public static class lolClass implements Comparable<lolClass>{
		
		private final String type;
		private final Time time;
		
		public lolClass(String type, Time time) {
			this.time = time;
			this.type = type;
		}
		
		public String getType(){
			return type;
		}
		
		public Time getTime(){
			return time;
		}

		@Override
		public int compareTo(lolClass o) {
			return time.compareTo(o.time);
		}
		
		
	}
	
}
