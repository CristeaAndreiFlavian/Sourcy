package org.sourcy;

import org.sourcy.glfw.SouGLFW;
import org.sourcy.opentlb.TLB1;

public class Sourcy {

	private static SouGLFW glfw = new SouGLFW(800, 600);
	private static TLB1 tlb = new TLB1();
	
	public static void main(String[] args) {
		glfw.createWindow(tlb.TLB_TRUE_LONG);
	}
	
}