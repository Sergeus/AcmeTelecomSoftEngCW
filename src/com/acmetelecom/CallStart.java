package com.acmetelecom;

import com.acmetelecom.time.TimeStamp;

public class CallStart extends CallEvent {
    public CallStart(String caller, String callee) {
        super(caller, callee, TimeStamp.now());
    }
    
    public CallStart(String caller, String callee, TimeStamp timeStamp) {
        super(caller, callee, timeStamp);
    }
}
