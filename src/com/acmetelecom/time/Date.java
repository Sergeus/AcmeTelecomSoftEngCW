package com.acmetelecom.time;

public class Date{
	
	private final int year, month, day;
	
	public Date(int year, int month, int day) {
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
