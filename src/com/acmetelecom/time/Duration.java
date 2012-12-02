package com.acmetelecom.time;

import org.joda.time.Period;

public class Duration{
	
	public static long inSeconds(TimeStamp start, TimeStamp end){
		return Period.fieldDifference(start.getDateTime(), end.getDateTime()).toStandardDuration().getStandardSeconds();
	}
	
	public static long inSeconds(Time start, Time end){
		return start.getSeconds(end) - end.getSeconds(start);
	}
}