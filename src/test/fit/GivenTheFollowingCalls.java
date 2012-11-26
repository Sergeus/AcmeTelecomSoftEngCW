package test.fit;


import test.fit.fakes.FakeCall;

import fit.ColumnFixture;

public class GivenTheFollowingCalls extends ColumnFixture {
	public String from;
	public String to;
	public Integer duration;
	
	@Override
	public void reset() throws Exception {
		from = null;
		to = null;
		duration = 0;
	}

	@Override
	public void execute() throws Exception {
		SystemUnderTest.billing.billCall(new FakeCall(from, to, duration));
	}
	
}
