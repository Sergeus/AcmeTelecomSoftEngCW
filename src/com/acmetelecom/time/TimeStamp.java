package com.acmetelecom.time;

import org.joda.time.LocalDateTime;

public class TimeStamp implements Comparable<TimeStamp>{
	
	private final LocalDateTime dateTime;
	
	LocalDateTime getDateTime(){
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

	@Override
	//TODO test this
	public int compareTo(TimeStamp o) {
		return dateTime.compareTo(o.dateTime);
	}

}
