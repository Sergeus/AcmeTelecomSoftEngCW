package com.acmetelecom.time;

/**
 * Represents the time of day (ie. 13:43:16)
 *
 */
public class Time{
		
	private final int hour, min, second;
	
	/**
	 * 
	 * @param hour hour of the day
	 * @param min minute of the hour
	 * @param second second of the minute
	 */
	public Time(int hour, int min, int second) {
		this.hour = hour;
		this.min = min;
		this.second = second;
	}
	
	/**
	 * Returns hour of the day
	 */
	public int getHour(){
		return hour;
	}
	
	/**
	 * Returns minute of the hour
	 */
	public int getMin(){
		return min;
	}
	
	/**
	 * Returns second of the minute
	 */
	public int getSecond(){
		return second;
	}
	
	public boolean isBefore(Time time){
		return (getSeconds(this) < getSeconds(time));
	}
	
	public boolean isAfter(Time time){
		return (getSeconds(this) >= getSeconds(time));
	}
	
	public boolean isBetween(Time start, Time end){
		return ((this.isAfter(start))&&(this.isBefore(end))); 
	}
	
	/**
	 * Returns total number of seconds for Time
	 */
	long getSeconds(Time t){
		long result = 0;
		
		result += t.getHour() * 60 * 60;
		result += t.getMin() * 60;
		result += t.getSecond();
		
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%d:%d:%d", hour, min, second);
	}
		
}
