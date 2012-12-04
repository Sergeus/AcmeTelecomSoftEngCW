package fit;


import com.acmetelecom.calls.PhoneNumber;
import com.acmetelecom.time.Date;
import com.acmetelecom.time.Time;
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
		
		Time startTime = new Time(Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]));
		Time endTime = new Time(Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));
		
		Date startDate = new Date(1970, 1, 1);
		Date endDate = new Date(1970, 1, 1);
		
		if (endTime.isBefore(startTime)) {
			endDate = new Date(1970, 1, 2);
		}
		
		TimeStamp startTimeStamp = new TimeStamp(startTime, startDate);
		TimeStamp endTimeStamp = new TimeStamp(endTime, endDate);
		
		PhoneNumber caller = new PhoneNumber(From);
		PhoneNumber callee = new PhoneNumber(To);
		
		SystemUnderTest.billing.callInitiated(caller, callee, startTimeStamp);
		SystemUnderTest.billing.callCompleted(caller, callee, endTimeStamp);
		
	}
	
}
