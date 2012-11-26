package com.acmetelecom;

import org.joda.time.LocalDateTime;

public abstract class CallEvent {
    private String caller;
    private String callee;
    private LocalDateTime time;

    public CallEvent(String caller, String callee, LocalDateTime timeStamp) {
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

    public LocalDateTime time() {
        return time;
    }
}
