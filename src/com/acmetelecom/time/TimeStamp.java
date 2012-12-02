package com.acmetelecom.time;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;

public class TimeStamp implements TimeStampIface{
	
	private final LocalDateTime dateTime;
	
	private LocalDateTime getDateTime(){
		return dateTime;
	}
	
	public Time getTime(){
		return new Time(dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute());
	}
	
	public Date getDate() {
		return new Date(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth());
	}
	
	public TimeStamp(){
		dateTime = LocalDateTime.now();
	}
	
	public TimeStamp(int year, int month, int day, int hour, int minute, int second){
		dateTime = new LocalDateTime(year, month, day, hour, minute, second);
	}
	
	public static Duration getDuration(TimeStamp start, TimeStamp end){
		return new Duration(start, end);
	}
	
	public static class Duration{
		
		private final org.joda.time.Duration duration;
		
		private Duration(TimeStamp start, TimeStamp end) {
			duration = Period.fieldDifference(start.getDateTime(), end.getDateTime()).toStandardDuration();;
		}
		
		public int getSeconds(){
			return duration.toStandardSeconds().getSeconds();
		}
	}

}
