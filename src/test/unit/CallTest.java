package test.unit;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acmetelecom.Call;
import com.acmetelecom.CallEnd;
import com.acmetelecom.CallStart;

public class CallTest {
	
	private String caller = "0000";
	private String callee = "1111";
	
	private CallStart callStart;
	private CallEnd callEnd;
	private CallEnd callEndOneSecond;
	
	Calendar c00 = Calendar.getInstance();
	Calendar c01 = Calendar.getInstance();

	@Before
	public void setUp() throws Exception {
		c00.clear();
		c01.clear();
		c00.set(1970, 01, 01, 00, 00, 00);
		c01.set(1970, 01, 01, 00, 00, 01);
		
		callStart = new CallStart(caller, callee, c00.getTimeInMillis());
		callEnd = new CallEnd(caller, callee, c00.getTimeInMillis());
		callEndOneSecond = new CallEnd(caller, callee, c01.getTimeInMillis());
	}

	@Test
	public void testCallee() {
		Call call = new Call(callStart, callEnd);
		Assert.assertEquals(call.callee(), callee);
	}

	@Test
	public void testDurationSeconds() {
		Call call = new Call(callStart, callEnd);
		Assert.assertEquals(call.durationSeconds(), 0);
		
		call = new Call(callStart, callEndOneSecond);
		Assert.assertEquals(call.durationSeconds(), 1);
	}

	@Test
	public void testDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartTime() {
		Call call = new Call(callStart, callEnd);
		Assert.assertEquals(call.startTime().compareTo(new Date(c00.getTimeInMillis())), 0);
	}

	@Test
	public void testEndTime() {
		Call call = new Call(callStart, callEnd);
		Assert.assertEquals(call.startTime().compareTo(new Date(c00.getTimeInMillis())), 0);
				
		call = new Call(callStart, callEndOneSecond);
		Assert.assertEquals(call.startTime().compareTo(new Date(c01.getTimeInMillis())), 0);
	}

}
