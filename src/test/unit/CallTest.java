package test.unit;

import junit.framework.Assert;

import org.joda.time.LocalDateTime;
import org.junit.Test;

import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallStart;

public class CallTest {
	
	private String caller = "0000";
	private String callee = "1111"; 
	
	LocalDateTime time = LocalDateTime.now();
	LocalDateTime timePlusTen = LocalDateTime.now().plusSeconds(10);
	
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
		Assert.assertEquals(call.date(), start.time().toString());
	}

	@Test
	public void testStartTime() {
		Call call = new Call(start, end);
		Assert.assertEquals(call.startTime(), time);
	}

	@Test
	public void testEndTime() {
		Call call = new Call(start, end);
		Assert.assertEquals(call.endTime(), time);
				
		call = new Call(start, endPlusTen);
		Assert.assertEquals(call.endTime(), timePlusTen);
	}

}
