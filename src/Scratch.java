import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.acmetelecom.billing.EventData;
import com.acmetelecom.billing.EventType;
import com.acmetelecom.time.Date;
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

		
		
		
		
		Time peakStart = new Time(22, 00, 00);
		Time peakEnd = new Time(02, 00, 00);
		
		TimeStamp startTimeStamp = new TimeStamp(2000, 1, 1, 21, 00, 00);
		TimeStamp endTimeStamp = new TimeStamp(2000, 1, 2, 01, 00, 00);
		
		Time startTime = startTimeStamp.getTime();
		Time endTime = endTimeStamp.getTime();
		
		Date startDate = startTimeStamp.getDate();
		
		long peakSeconds = 0;
		long offpeakSeconds = 0;
		
		SortedSet<EventData> t = new TreeSet<EventData>();
		
		TimeStamp peakStartTimeStamp = new TimeStamp(peakStart, startDate);
		TimeStamp peakEndTimeStamp = new TimeStamp(peakEnd, startDate);
		
//		if (/*peakEnd.isBefore(peakStart) ||*/ peakEnd.isBefore(startTime)) {
//			System.out.println("Added day to peakEndTimeStamp");
//			peakEndTimeStamp = peakEndTimeStamp.addDay();
//		}
//		
//		if (peakStart.isBefore(startTime)){
//			System.out.println("Added say to PeakStartTimeStamp");
//			peakStartTimeStamp = peakStartTimeStamp.addDay();
//		}
		
		t.add(new EventData(EventType.PEAK_START, peakStartTimeStamp));
		t.add(new EventData(EventType.PEAK_END, peakEndTimeStamp));
		t.add(new EventData(EventType.PEAK_START, peakStartTimeStamp.addDay()));
		t.add(new EventData(EventType.PEAK_END, peakEndTimeStamp.addDay()));
		t.add(new EventData(EventType.CALL_END, endTimeStamp));
		
		int i = 0;
		for (EventData e : t) {
			System.out.println(i++ + " " + e.getType() + " " + e.getTime().getTime());
		}
		
		System.out.println("startTime: " + startTime + ". endTime: " + endTime);
		
		TimeStamp startOfPeriod = startTimeStamp;
		
		Iterator<EventData> it = t.iterator();
		while (it.hasNext()) {
			EventData e = (EventData) it.next();
			
			if (!e.getTime().isBefore(startTimeStamp)) {
				//System.out.println(e.getType() + " " + e.getTime().getTime());
				if (e.getType() == EventType.CALL_END) {
					
					// Problem is here
					if (it.next().getType() == EventType.PEAK_END) {
						System.out.println("A");
						peakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
					} else{
						System.out.println("B");
						offpeakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
					}
					
					break;
				}
				
				if (e.getType() == EventType.PEAK_START) {
					System.out.println("C");
					offpeakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
				} else {
					System.out.println("D");
					peakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
				}
				
				startOfPeriod = e.getTime();
				System.out.println("peak seconds: " + peakSeconds + ". off-peak seconds: " + offpeakSeconds);
				
			}
			
		}
		
//		for (lolClass e : t) {
//			if (!e.getTime().isBefore(startTimeStamp)) {
//				//System.out.println(e.getType() + " " + e.getTime().getTime());
//				if (e.getType() == "final") {
//					
//					// Problem is here
//					if (e.getTime().isBetween(peakStartTimeStamp, peakEndTimeStamp)
//							|| e.getTime().isBetween(peakStartTimeStamp.addDay(), peakEndTimeStamp.addDay())) {
//						System.out.println("A");
//						peakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
//					} else{
//						System.out.println("B");
//						offpeakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
//					}
//					
//					break;
//				}
//				
//				if (e.getType() == "start") {
//					System.out.println("C");
//					offpeakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
//				} else {
//					System.out.println("D");
//					peakSeconds += Duration.inSeconds(startOfPeriod, e.getTime());
//				}
//				
//				startOfPeriod = e.getTime();
//				System.out.println("peak seconds: " + peakSeconds + ". off-peak seconds: " + offpeakSeconds);
//				
//			}
//		}
		
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
	
}
