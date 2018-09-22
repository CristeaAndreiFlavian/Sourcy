package org.sourcy.util;

import org.sourcy.util.debug.DebugLogger;

public interface SV {
	
	static void getVersion() {
		String name = "Sourcy";
		if (name != "Sourcy") {
			throw new IllegalStateException("ERROR: In the version class, the name isn't setted to Sourcy, or it couln't initialize correctly!");
		}
		if (name == "Sourcy") {
			DebugLogger.logInfo(name+" Version: PT 9222018, Built 1");
		}
	}
	
}