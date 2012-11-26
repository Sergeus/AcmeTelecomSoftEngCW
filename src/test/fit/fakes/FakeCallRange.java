package test.fit.fakes;

import java.util.ArrayList;

public class FakeCallRange {
	private final ArrayList<FakeCall> callRange = new ArrayList<FakeCall>();

	public void deleteAll() {
		callRange.clear();
	}

	public void addCall(FakeCall call) {
		callRange.add(call);
	}
	
	public ArrayList<FakeCall> getCallRange(){
		return callRange;
	}
}
