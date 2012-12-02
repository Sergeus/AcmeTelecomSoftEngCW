package com.acmetelecom.calls;

import com.acmetelecom.time.TimeStamp;
import com.acmetelecom.time.Time;

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

    public int durationSeconds() {
    	return TimeStamp.getDuration(start.getTimeStamp(), end.getTimeStamp()).getSeconds();
    }

    public String date() {
        return start.getTimeStamp().getDate().toString();
    }

    public Time startTime() {
        return start.getTimeStamp().getTime();
    }

    public Time endTime() {
        return end.getTimeStamp().getTime();
    }
}
