package com.acmetelecom.calls;

import com.acmetelecom.time.Date;
import com.acmetelecom.time.Duration;
import com.acmetelecom.time.Time;
import com.acmetelecom.time.TimeStamp;

public class Call {
    private CallEvent start;
    private CallEvent end;

    public Call(CallEvent start, CallEvent end) {
        this.start = start;
        this.end = end;
    }

    public String callee() {
        return start.getCallee();
    }
    
    public String caller() {
        return start.getCaller();
    }

    public long durationSeconds() {
    	return Duration.inSeconds(start.getTimeStamp(), end.getTimeStamp());
    }

    public Date date() {
        return start.getTimeStamp().getDate();
    }

    public Time startTime() {
        return start.getTimeStamp().getTime();
    }

    public Time endTime() {
        return end.getTimeStamp().getTime();
    }
    
    public TimeStamp startTimeStamp() {
        return start.getTimeStamp();
    }

    public TimeStamp endTimeStamp() {
        return end.getTimeStamp();
    }
}
