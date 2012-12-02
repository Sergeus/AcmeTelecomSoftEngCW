package fit;


import com.acmetelecom.billing.DaytimePeakPeriod;
import com.acmetelecom.time.Time;

public class GivenTheFollowingPeakHours extends ColumnFixture {
	public String From;
	public String To;
	
	@Override
	public void reset() throws Exception {
		From = null;
		To = null;
	}

	@Override
	public void execute() throws Exception {
		String[] start = From.split(":");
		String[] end = To.split(":");
		
		Time startTime = new Time(Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]));
		Time endTime = new Time(Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));

		DaytimePeakPeriod.setPeakStart(startTime);
		DaytimePeakPeriod.setPeakEnd(endTime);
		
	}
	
}
