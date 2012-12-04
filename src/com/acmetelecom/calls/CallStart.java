package com.acmetelecom.calls;

import com.acmetelecom.time.TimeStamp;
/**
 * 
 * Implements call event for the start of calls
 *
 */
public class CallStart extends CallEvent {
	@Deprecated
    public CallStart(String caller, String callee){
        super(new PhoneNumber(caller), new PhoneNumber(callee), new TimeStamp());
    }
    
	@Deprecated
    public CallStart(String caller, String callee, TimeStamp timeStamp){
        super(new PhoneNumber(caller), new PhoneNumber(callee), timeStamp);
    }
    
    public CallStart(PhoneNumber caller, PhoneNumber callee) {
        super(caller, callee, new TimeStamp());
    }
    
    public CallStart(PhoneNumber caller, PhoneNumber callee, TimeStamp timeStamp) {
        super(caller, callee, timeStamp);
    }
}
