package test.unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acmetelecom.time.Time;

public class TimeTest {
	
	private static Time t1, t2, t3, t4;

	@Before
	public void setUp() throws Exception {
		t1 = new Time(11, 59, 59);
		t2 = new Time(12, 0, 0);
		t3 = new Time(12, 0, 1);
		t4 = new Time(12, 0, 0);
	}

	@Test
	public void isBeforeTest() {
		assertTrue(t1.isBefore(t2));
		assertTrue(t2.isBefore(t3));
		
		assertFalse(t3.isBefore(t2));
		assertFalse(t2.isBefore(t1));
	}
	
	@Test
	public void isAfterTest() {
		assertTrue(t3.isAfter(t2));
		assertTrue(t2.isAfter(t1));
		
		assertFalse(t1.isAfter(t2));
		assertFalse(t2.isAfter(t3));
	}
	
	@Test
	public void isEqual() {
		assertTrue(t2.isEqual(t4));
		assertFalse(t2.isEqual(t3));
	}
	
	@Test
	public void isBetween() {
		assertTrue(t2.isBetween(t1, t3));
		assertTrue(t2.isBetween(t1, t2));
		assertTrue(t1.isBetween(t1, t2));
		
		assertFalse(t3.isBetween(t1, t2));
	}

}
