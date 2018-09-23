package org.sourcy;

import org.sourcy.glfw.SouGLFW;
import org.sourcy.logic.Logic;
import org.sourcy.opentlb.TLB1;

public class Sourcy extends Logic {

	private static SouGLFW glfw;
	private static TLB1 tlb;
	
	public static void main(String[] args) {
		new Sourcy().startGame(tlb.TLB_TRUE_LONG);
	}

	@Override
	protected void initComponents(SouGLFW win) {
		glfw = new SouGLFW(800, 600);
		tlb = new TLB1();
	}

	@Override
	public void update(SouGLFW win) {
		if (win.isClosed()) {
			new Sourcy().stopGame(0);
		}
		win.handleWindow();
	}

	@Override
	public void render(SouGLFW win) {
		
	}

	@Override
	public void init(SouGLFW win) {
		win.createWindow();
	}
	
}