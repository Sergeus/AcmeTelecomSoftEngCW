import com.acmetelecom.time.TimeStamp;


public class PeakPeriod {
	
	private final TimeStamp start;
	private final TimeStamp end;
	
	public PeakPeriod(TimeStamp start, TimeStamp end) {
		this.start = start;
		this.end = end;
	}
	
	public TimeStamp getStart(){
		return start;
	}
	
	public TimeStamp getEnd(){
		return end;
	}

}
