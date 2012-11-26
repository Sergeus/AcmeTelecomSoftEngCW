package test.unit;

import junit.framework.Assert;

import org.junit.Test;

import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallStart;
import com.acmetelecom.time.TimeStamp;

public class CallTest {
	
	private String caller = "0000";
	private String callee = "1111";
	
	TimeStamp time = TimeStamp.getInstance(2000, 1, 1, 0, 0, 0, 0);
	TimeStamp timePlusTen = TimeStamp.getInstance(2000, 1, 1, 0, 0, 10, 0);
	
	private CallStart start = new CallStart(caller, callee, time);
	private CallEnd end = new CallEnd(caller, callee, time);
	private CallEnd endPlusTen = new CallEnd(caller, callee, timePlusTen);

	@Test
	public void testCallee() {
		Call call = new Call(start, end);
		Assert.assertEquals(call.callee(), callee);
	}

	@Test
	public void testDurationSeconds() {
		Call call = new Call(start, end);
		Assert.assertEquals(call.durationSeconds(), 0);
		
		call = new Call(start, endPlusTen);
		Assert.assertEquals(call.durationSeconds(), 10);
	}

	@Test
	public void testDate() {
		Call call = new Call(start, end);
		Assert.assertEquals(call.date(), time.getDate().toString());
	}

	@Test
	public void testStartTime() {
		Call call = new Call(start, end);
		Assert.assertEquals(call.startTime().toString(), time.getTime().toString());
	}

	@Test
	public void testEndTime() {
		Call call = new Call(start, end);
		Assert.assertEquals(call.endTime().toString(), time.getTime().toString());
				
		call = new Call(start, endPlusTen);
		Assert.assertEquals(call.endTime().toString(), timePlusTen.getTime().toString());
	}

}
