package com.acmetelecom;

import com.acmetelecom.time.TimeStamp;

public abstract class CallEvent {
    private String caller;
    private String callee;
    private TimeStamp time;

    public CallEvent(String caller, String callee, TimeStamp timeStamp) {
        this.caller = caller;
        this.callee = callee;
        this.time = timeStamp;
    }

    public String getCaller() {
        return caller;
    }

    public String getCallee() {
        return callee;
    }

    public TimeStamp getTimeStamp() {
        return time;
    }
}
