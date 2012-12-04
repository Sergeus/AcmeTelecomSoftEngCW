package com.acmetelecom.calls;

import com.acmetelecom.time.TimeStamp;

public abstract class CallEvent {
    private PhoneNumber caller;
    private PhoneNumber callee;
    private TimeStamp time;

    public CallEvent(PhoneNumber caller, PhoneNumber callee, TimeStamp timeStamp) {
        this.caller = caller;
        this.callee = callee;
        this.time = timeStamp;
    }

    public String getCaller() {
        return caller.toString();
    }

    public String getCallee() {
        return callee.toString();
    }

    public TimeStamp getTimeStamp() {
        return time;
    }
}
