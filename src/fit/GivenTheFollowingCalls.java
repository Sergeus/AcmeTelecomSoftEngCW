package fit;


import com.acmetelecom.fakes.FakeCall;

import fit.ColumnFixture;

public class GivenTheFollowingCalls extends ColumnFixture {
	public String From;
	public String To;
	public Integer Duration;
	
	@Override
	public void reset() throws Exception {
		From = null;
		To = null;
		Duration = 0;
	}

	@Override
	public void execute() throws Exception {
		SystemUnderTest.billing.billCall(new FakeCall(From, To, Duration));
	}
	
}
