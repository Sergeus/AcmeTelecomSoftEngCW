package com.acmetelecom.time;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;

public class TimeStamp implements TimeStampIface{
	
	private final LocalDateTime dateTime;
	
	private TimeStamp(LocalDateTime timeStamp) {
		dateTime = timeStamp;
	}
	
	private LocalDateTime getDateTime(){
		return dateTime;
	}
	
	public Date getDate(){
		return new Date(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth());
	}
	
	public Time getTime(){
		return new Time(dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute(), dateTime.getMillisOfSecond());
	}
	
	public static TimeStamp now(){
		return new TimeStamp(LocalDateTime.now());
	}
	
	public static TimeStamp getInstance(int year, int month, int day, int hour, int minute, int second, int milli){
		return new TimeStamp(new LocalDateTime(year, month, day, hour, minute, second, milli));
	}
	
	public static Duration getDurationInSeconds(TimeStamp start, TimeStamp end){
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
	
	public static class Date implements DateIface{
		
		private final int year, month, day;
		
		private Date(int year, int month, int day) {
			this.year = year;
			this.month = month;
			this.day = day;
		}
		
		public int getYear(){
			return year;
		}
		
		public int getMonth(){
			return month;
		}
		
		public int getDay(){
			return day;
		}
		
		@Override
		public String toString() {
			return String.format("%d-%d-%d", day, month, year);
		}
		
	}
	
	public static class Time implements TimeIface{
		
		private final int hour, min, second, milli;
		
		private Time(int hour, int min, int second, int milli) {
			this.hour = hour;
			this.min = min;
			this.second = second;
			this.milli = milli;
		}
		
		public int getHour(){
			return hour;
		}
		
		public int getMin(){
			return min;
		}
		
		public int getSecond(){
			return second;
		}
		
		public int getMilli(){
			return milli;
		}
		
		@Override
		public String toString() {
			return String.format("%d:%d:%d:%d", hour, min, second, milli);
		}
		
	}
}
