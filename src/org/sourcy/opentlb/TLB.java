package org.sourcy.opentlb;

import org.sourcy.util.debug.DebugLogger;

public interface TLB {

	static void getVersion() {
		String name = "OpenTLB";
		if (name != "OpenTLB") {
			throw new IllegalStateException("ERROR: In the OpenTLB main class, the name isn't setted to OpenTLB, or it couln't initialize correctly!");
		}
		if (name == "OpenTLB") {
			DebugLogger.logInfo(name+" Version: PT 9222018, Built 1");
		}
	}
	
}