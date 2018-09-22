package org.sourcy;

import org.sourcy.glfw.SouGLFW;
import org.sourcy.opentlb.OpenTLB01;

public class Sourcy {

	private static SouGLFW glfw = new SouGLFW(800, 600);
	private static OpenTLB01 tlb = new OpenTLB01();
	
	public static void main(String[] args) {
		glfw.createWindow(tlb.TLB_TRUE_LONG);
	}
	
}