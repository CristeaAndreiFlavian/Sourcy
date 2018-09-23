package org.sourcy.logic;

import org.sourcy.glfw.SouGLFW;
import org.sourcy.opentlb.TLB1;
import org.sourcy.util.debug.DebugLogger;

public abstract class Logic {

	private SouGLFW win;
	
	protected abstract void initComponents(SouGLFW win);
	public abstract void update(SouGLFW win);
	public abstract void render(SouGLFW win);
	public abstract void init(SouGLFW win);
	
	protected void startGame(long fps) {
		initComponents(win);
		init(win);
		while (true) {
			update(win);
			render(win);
			if (fps == 999999999) {
				DebugLogger.customInfo("FPS: " + TLB1.getFPS(), 000000000);
			}
		}
	}
	
	public void stopGame(int status) {
		win.closeWindow(status);
	}
	
	public SouGLFW getWin() {
		return win;
	}
	
}