package org.sourcy;

import org.sourcy.glfw.SouGLFW;
import org.sourcy.shared.SYImpl;

import static org.sourcy.shared.SY10.*;

public class Sourcy {

	private static SouGLFW glfw;
	
	public static void main(String[] args) {
		Sourcy sourcy = new Sourcy();
		glfw = new SouGLFW(620, 480);
		sourcy.init(glfw);
		sourcy.initComponents(glfw);
		glfw.show();
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
		sySetImplementation(SYImpl.OPENGL);
		syInit(SouGLFW.getPrimaryMonitor(), win);
		System.out.println("Inited with OPENGL and " + SouGLFW.getPrimaryMonitor() + " monitor ID");
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