package test.unit;

public class SleepHelper {
	public static void sleepSeconds(int n) throws InterruptedException {
		Thread.sleep(n * 1000);
	}
}
