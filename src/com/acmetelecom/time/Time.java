package com.acmetelecom.time;

public class Time implements TimeIface {
		
	private final int hour, min, second, milli;
	
	public Time(int hour, int min, int second, int milli) {
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
