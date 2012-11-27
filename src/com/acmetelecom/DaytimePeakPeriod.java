package com.acmetelecom;

import org.joda.time.LocalDateTime;

class DaytimePeakPeriod {

    public boolean offPeak(LocalDateTime time) {
        int hour = time.getHourOfDay();
        return hour < 7 || hour >= 19;
    }
}
