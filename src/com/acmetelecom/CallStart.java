package com.acmetelecom;

import org.joda.time.LocalDateTime;

public class CallStart extends CallEvent {
    public CallStart(String caller, String callee) {
        super(caller, callee, LocalDateTime.now());
    }
    
    public CallStart(String caller, String callee, LocalDateTime timeStamp) {
        super(caller, callee, timeStamp);
    }
}
