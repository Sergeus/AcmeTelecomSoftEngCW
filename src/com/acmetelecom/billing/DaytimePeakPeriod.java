package com.acmetelecom.billing;

import com.acmetelecom.time.TimeStamp.Time;

public class DaytimePeakPeriod {

    public boolean offPeak(Time time) {
        int hour = time.getHour();
        return hour < 7 || hour >= 19;
    }
}