package com.acmetelecom.calls;

import com.acmetelecom.PhoneNumber;
import com.acmetelecom.time.TimeStamp;

public class CallEnd extends CallEvent {
	@Deprecated
    public CallEnd(String caller, String callee){
        super(new PhoneNumber(caller), new PhoneNumber(callee), TimeStamp.now());
    }
    
	@Deprecated
    public CallEnd(String caller, String callee, TimeStamp timeStamp){
        super(new PhoneNumber(caller), new PhoneNumber(callee), timeStamp);
    }
    
    public CallEnd(PhoneNumber caller, PhoneNumber callee) {
        super(caller, callee, TimeStamp.now());
    }
    
    public CallEnd(PhoneNumber caller, PhoneNumber callee, TimeStamp timeStamp) {
        super(caller, callee, timeStamp);
    }
}
