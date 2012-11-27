package com.acmetelecom;

import com.acmetelecom.time.TimeStamp;

public class CallEnd extends CallEvent {
    public CallEnd(String caller, String callee) {
        super(caller, callee, TimeStamp.now());
    }
    
    public CallEnd(String caller, String callee, TimeStamp timeStamp) {
        super(caller, callee, timeStamp);
    }
}
