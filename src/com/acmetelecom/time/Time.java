package com.acmetelecom.time;

/**
 * Represents the time of day (ie. 13:43:16)
 * @Immutable
 */
public class Time implements Comparable<Time> {
		
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
		return (this.getAllSeconds() < time.getAllSeconds());
	}
	
	public boolean isAfter(Time time){
		return (this.getAllSeconds() > time.getAllSeconds());
	}
	
	public boolean isEqual(Time time){
		return (this.getAllSeconds() == time.getAllSeconds());
	}
	
	public boolean isBetween(Time start, Time end){
		return ( (this.isAfter(start) && this.isBefore(end)) ||
					(this.isEqual(start) || this.isEqual(end)) ); 
	}
	
	/**
	 * Returns total number of seconds for Time
	 */
	long getAllSeconds(){
		long result = 0;
		
		result += this.getHour() * 60 * 60;
		result += this.getMin() * 60;
		result += this.getSecond();
		
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%d:%d:%d", hour, min, second);
	}

	@Override
	public int compareTo(Time o) {
		
		if (this.isBefore(o)) {
			return -1;
		}
		
		if (this.isEqual(o)) {
			return 0;
		}
		
		return 1;
	}
		
}
