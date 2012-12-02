package com.acmetelecom.billing;

import com.acmetelecom.time.Time;

public class DaytimePeakPeriod {
	
	private static Time startTime;
	private static Time endTime;
	private static DaytimePeakPeriod peakPeriod = new DaytimePeakPeriod();
	
	/**
	 * Default constructor sets default peak times.
	 * Peak starts at 7000 and ends at 1900.
	 */
	private DaytimePeakPeriod() {
		startTime = new Time(7, 0, 0);
		endTime = new Time(19, 0, 0);
	}
	
	public static DaytimePeakPeriod getInstance(){
		return peakPeriod;
	}
	
	public static void setPeakStart(Time time){
		startTime = time;
	}
	
	/**
	 * Returns (immutable) start time
	 * @return Time
	 */
	public static Time getPeakStart(){
		return startTime;
	}
	
	public static void setPeakEnd(Time time){
		endTime = time;
	}

	/**
	 * Returns (immutable) end time
	 * @return Time
	 */
	public static Time getPeakEnd(){
		return endTime;
	}

    public boolean offPeak(Time time) {
        return (time.getHour() < startTime.getHour() ||
        		 time.getHour() >= endTime.getHour());
    }
}
