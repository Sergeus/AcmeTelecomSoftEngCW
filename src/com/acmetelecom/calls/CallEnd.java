package com.acmetelecom.calls;

import com.acmetelecom.time.TimeStamp;

public class CallEnd extends CallEvent {
	@Deprecated
    public CallEnd(String caller, String callee){
        super(new PhoneNumber(caller), new PhoneNumber(callee), new TimeStamp());
    }
    
	@Deprecated
    public CallEnd(String caller, String callee, TimeStamp timeStamp){
        super(new PhoneNumber(caller), new PhoneNumber(callee), timeStamp);
    }
    
    public CallEnd(PhoneNumber caller, PhoneNumber callee) {
        super(caller, callee, new TimeStamp());
    }
    
    public CallEnd(PhoneNumber caller, PhoneNumber callee, TimeStamp timeStamp) {
        super(caller, callee, timeStamp);
    }
}
