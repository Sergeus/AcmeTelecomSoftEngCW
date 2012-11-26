package com.acmetelecom;

import org.joda.time.Duration;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

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

    public int durationSeconds() {
    	Duration d = Period.fieldDifference(start.time(), end.time()).toStandardDuration();
    	return d.toStandardSeconds().getSeconds();
    }

    public String date() {
        return start.time().toString();
    }

    public LocalDateTime startTime() {
        return start.time();
    }

    public LocalDateTime endTime() {
        return end.time();
    }
}
