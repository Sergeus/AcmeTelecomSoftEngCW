package com.acmetelecom.time;

public class Time implements TimeIface {
		
	private final int hour, min, second;
	
	public Time(int hour, int min, int second) {
		this.hour = hour;
		this.min = min;
		this.second = second;
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
	
	@Override
	public String toString() {
		return String.format("%d:%d:%d", hour, min, second);
	}
		
}
