package com.acmetelecom.time;

import org.joda.time.LocalDateTime;

/**
 * TimeStamp holds the date and time for a particular instant in history.
 * @immutable
 */
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
	
	/**
	 * Obtains a TimeStamp set to the current system time
	 */
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
	
	public boolean isBefore(TimeStamp time){
		return dateTime.isBefore(time.getDateTime());
	}
	
	public boolean isAfter(TimeStamp time){
		return dateTime.isAfter(time.getDateTime());
	}
	
	public boolean isEquals(TimeStamp time){
		return dateTime.isEqual(time.getDateTime());
	}

	@Override
	public int compareTo(TimeStamp o) {
		return dateTime.compareTo(o.dateTime);
	}

	/**
	 * @return copy of the TimeStamp with an additional day
	 */
	public TimeStamp addDay() {
		return new TimeStamp(dateTime.plusDays(1));
	}

}
