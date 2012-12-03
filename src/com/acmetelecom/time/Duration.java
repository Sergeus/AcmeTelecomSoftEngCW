package com.acmetelecom.time;

import org.joda.time.Period;

public class Duration{
	
	public static long inSeconds(TimeStamp start, TimeStamp end){
		return Period.fieldDifference(start.getDateTime(), end.getDateTime()).toStandardDuration().getStandardSeconds();
	}
	
	public static long inDays(TimeStamp start, TimeStamp end){
		return Period.fieldDifference(start.getDateTime(), end.getDateTime()).toStandardDuration().getStandardDays();
	}
	
	public static long inSeconds(Time start, Time end){
		
		if (end.isBefore(start)) {
			end = new Time(end.getHour()+24, end.getMin(), end.getSecond());
		}
		
//		if ((start.getSeconds(end) - end.getSeconds(start)) < 0) {
//			throw new RuntimeException("Duration should not be negative!");
//		}
		
		return end.getSeconds() - start.getSeconds();
	}
}