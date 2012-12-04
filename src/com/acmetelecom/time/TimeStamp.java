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

	public TimeStamp(Time time, Date date) {
		dateTime = new LocalDateTime(date.getYear(), date.getMonth(), date.getDay(), time.getHour(), time.getMin(), time.getSecond());
	}
	
	private TimeStamp(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isBetween(TimeStamp start, TimeStamp end){
		return ( (dateTime.isAfter(start.getDateTime()) && dateTime.isBefore(end.getDateTime())) ||
					(dateTime.isEqual(start.getDateTime()) || dateTime.isEqual(end.getDateTime())) ); 
	}
	
	public boolean isBefore(TimeStamp time){
		return dateTime.isBefore(time.getDateTime());
	}

	@Override
	public int compareTo(TimeStamp o) {
		return dateTime.compareTo(o.dateTime);
	}

	public TimeStamp addDay() {
		return new TimeStamp(dateTime.plusDays(1));
	}

}
