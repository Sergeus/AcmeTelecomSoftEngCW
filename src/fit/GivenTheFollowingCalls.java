package fit;


import com.acmetelecom.PhoneNumber;
import com.acmetelecom.time.TimeStamp;

public class GivenTheFollowingCalls extends ColumnFixture {
	public String From;
	public String To;
	public String StartTime;
	public String EndTime;
	
	@Override
	public void reset() throws Exception {
		From = null;
		To = null;
		StartTime = null;
		EndTime = null;
	}

	@Override
	public void execute() throws Exception {
		String[] start = StartTime.split(":");
		String[] end = EndTime.split(":");
		
		TimeStamp startTimeStamp = new TimeStamp(1970, 1, 1, Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]));
		TimeStamp endTimeStamp = new TimeStamp(1970, 1, 1, Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));
		
		PhoneNumber caller = new PhoneNumber(From);
		PhoneNumber callee = new PhoneNumber(To);
		
		SystemUnderTest.billing.callInitiated(caller, callee, startTimeStamp);
		SystemUnderTest.billing.callCompleted(caller, callee, endTimeStamp);
		
	}
	
}
