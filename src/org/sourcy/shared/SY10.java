package org.sourcy.shared;

import org.sourcy.glfw.SouGLFW;

public final class SY10 {

	static SYImpl impl;
	static long monitor;
	
	static SouGLFW fwWin;
	
	static int vpX, vpY, vpW, vpH;
	
	
	public static void sySetImplementation(SYImpl impl) {
		if (impl == SYImpl.VULKAN || impl == SYImpl.DIRECTX) {
			throw new UnsupportedOperationException(impl.toString());
		}
		SY10.impl = impl;
	}
	
	public static void syInit(long monitor, Object window) {
		if (impl == SYImpl.OPENGL) { // GLFW
			SY10.monitor = monitor;
			fwWin = (SouGLFW) window;
		}
	}
	
	public static void sySetViewport(int vpX, int vpY, int vpW, int vpH) {
		SY10.vpX = vpX;
		SY10.vpY = vpY;
		SY10.vpW = vpW;
		SY10.vpH = vpH;
	}
	
}
