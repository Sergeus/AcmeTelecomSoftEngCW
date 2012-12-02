package fit;


import com.acmetelecom.PhoneNumber;
import com.acmetelecom.time.TimeStamp;

public class GivenTheFollowingOrderedCalls extends ColumnFixture {
	public String From;
	public String To;
	public String EventType;
	public String Time;
	
	@Override
	public void reset() throws Exception {
		From = null;
		To = null;
		EventType = null;
		Time = null;
	}

	@Override
	public void execute() throws Exception {
		String[] time = Time.split(":");
		
		TimeStamp timeStamp = new TimeStamp(1970, 1, 1, Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
		
		PhoneNumber caller = new PhoneNumber(From);
		PhoneNumber callee = new PhoneNumber(To);
		
		if (EventType.equals("start")) {
			SystemUnderTest.billing.callInitiated(caller, callee, timeStamp);
		} else {
			SystemUnderTest.billing.callCompleted(caller, callee, timeStamp);
		}
		
	}
	
}
