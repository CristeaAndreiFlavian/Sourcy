package org.sourcy;

import org.sourcy.glfw.SouGLFW;

public class Sourcy {

	private static SouGLFW glfw;
	
	public static void main(String[] args) {
		Sourcy sourcy = new Sourcy();
		glfw = new SouGLFW(620, 480);
		sourcy.init(glfw);
		sourcy.initComponents(glfw);
		
		while (true) {
			try {
				sourcy.update(glfw);
				sourcy.render(glfw);
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void initComponents(SouGLFW win) {
		
	}
	
	public void update(SouGLFW win) {
		if (win.isClosed()) {
			System.exit(0);
		}
		win.handleWindow();
	}
	
	public void render(SouGLFW win) {
		
	}
	
	public void init(SouGLFW win) {
		win.createWindow();
	}
	
}