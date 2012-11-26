package com.acmetelecom;

import org.joda.time.LocalDateTime;

public class CallEnd extends CallEvent {
    public CallEnd(String caller, String callee) {
        super(caller, callee, LocalDateTime.now());
    }
    
    public CallEnd(String caller, String callee, LocalDateTime timeStamp) {
        super(caller, callee, timeStamp);
    }
}
