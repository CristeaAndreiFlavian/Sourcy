package org.sourcy.opentlb;

public class TLB1 {

	private static long lastFPSCheck = 0;
	private static int currentFPS = 0;
	private static int currentFrames = 0;
	
	public static final boolean TLB_TRUE_BOOLEAN = true;
	public static final boolean TLB_FALSE_BOOLEAN = false;
	public static final long TLB_TRUE_LONG = 999999999;
	public static final long TLB_FALSE_LONG = 000000000;
	public static final int TLB_TRUE_INT = 1;
	public static final int TLB_FALSE_INT = 0;
	
	protected static void countFPS() {
		currentFrames++;
		if (System.nanoTime() > lastFPSCheck + 1000000000) {
			lastFPSCheck = System.nanoTime();
			currentFPS = currentFrames;
			currentFrames = 0;
		}
	}
	
	public static int getFPS() {
		countFPS();
		return currentFPS;
	}
	
}