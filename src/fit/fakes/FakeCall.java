package fit.fakes;

public class FakeCall {
	
	private final String from;
	private final String to;
	private final Integer duration;
	
	public FakeCall(String from, String to, Integer duration) {
		this.from = from;
		this.to = to;
		this.duration = duration;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public Integer getDuration() {
		return duration;
	}
	
}
