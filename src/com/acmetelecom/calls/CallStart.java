package com.acmetelecom.calls;

import com.acmetelecom.PhoneNumber;
import com.acmetelecom.time.TimeStamp;

public class CallStart extends CallEvent {
	@Deprecated
    public CallStart(String caller, String callee){
        super(new PhoneNumber(caller), new PhoneNumber(callee), TimeStamp.now());
    }
    
	@Deprecated
    public CallStart(String caller, String callee, TimeStamp timeStamp){
        super(new PhoneNumber(caller), new PhoneNumber(callee), timeStamp);
    }
    
    public CallStart(PhoneNumber caller, PhoneNumber callee) {
        super(caller, callee, TimeStamp.now());
    }
    
    public CallStart(PhoneNumber caller, PhoneNumber callee, TimeStamp timeStamp) {
        super(caller, callee, timeStamp);
    }
}
