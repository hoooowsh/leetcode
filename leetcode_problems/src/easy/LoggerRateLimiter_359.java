package easy;

import java.util.HashMap;

public class LoggerRateLimiter_359 {

	public static void main(String args[]) {
		Logger lg = new Logger();
		System.out.println(lg.shouldPrintMessage(0, "A"));
		System.out.println(lg.shouldPrintMessage(0, "B"));
		System.out.println(lg.shouldPrintMessage(0, "C"));
		System.out.println(lg.shouldPrintMessage(0, "A"));
		System.out.println(lg.shouldPrintMessage(0, "B"));
		System.out.println(lg.shouldPrintMessage(0, "C"));
		System.out.println(lg.shouldPrintMessage(11, "A"));
		System.out.println(lg.shouldPrintMessage(11, "B"));
		System.out.println(lg.shouldPrintMessage(11, "C"));
		System.out.println(lg.shouldPrintMessage(11, "A"));
	}

	public static class Logger {
		HashMap<String, Integer> hash;

		public Logger() {
			hash = new HashMap<>();
		}

		public boolean shouldPrintMessage(int timestamp, String message) {
			if (!hash.containsKey(message)) {
				hash.put(message, timestamp);
				return true;
			} else {
				if (timestamp - hash.get(message) >= 10) {
					hash.put(message, timestamp);
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
