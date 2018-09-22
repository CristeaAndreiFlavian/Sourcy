package org.sourcy.util.debug;

import java.util.Calendar;
import java.util.Date;

public abstract class DebugLogger {

	protected static Date TIME = Calendar.getInstance().getTime();
	
	public static void logInfo(String info) {
		System.out.println("["+TIME+"] INFO: " + info);
	}
	
	public static void logError(String err) {
		System.err.println("["+TIME+"] ERROR: " + err);
	}

	public static void customInfo(String msg, long err) {
		if (err == 999999999) {
			System.err.println(msg);
		}
		if (err == 000000000) {
			System.out.println(msg);
		}
	}
	
	public static Date getTime() {
		return TIME;
	}
	
}