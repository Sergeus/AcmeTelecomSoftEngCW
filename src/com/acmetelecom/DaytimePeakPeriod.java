package com.acmetelecom;

import com.acmetelecom.time.TimeStamp.Time;

class DaytimePeakPeriod {

    public boolean offPeak(Time time) {
        int hour = time.getHour();
        return hour < 7 || hour >= 19;
    }
}
