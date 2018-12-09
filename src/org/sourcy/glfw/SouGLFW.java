package org.sourcy.glfw;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;
import org.sourcy.util.debug.DebugLogger;

public class SouGLFW {

	private long window;
	private int winWidth, winHeight;
	private String winTitle;
	private static boolean inited;
	
	//Constructor
	public SouGLFW(int WIDTH, int HEIGHT) {
		this.winWidth = WIDTH;
		this.winHeight = HEIGHT;
		this.winTitle = "Sourcy Addon";
	}
	
	public static long getPrimaryMonitor() {
		return GLFW.glfwGetPrimaryMonitor();
	}
	
	static void initGLFW() {
		inited = GLFW.glfwInit();
		if (!inited) {
			throw new IllegalStateException("ERROR: Sourcy is unable to initialize GLFW!");
		}
		DebugLogger.logInfo("LWJGL " + Version.getVersion());
	}
	
	public void createWindow() {
		if (!inited)
			initGLFW();
		
		//Window hints
		GLFW.glfwDefaultWindowHints();
		GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
		
		//Initializing the window
		window = GLFW.glfwCreateWindow(winWidth, winHeight, winTitle, MemoryUtil.NULL, MemoryUtil.NULL);
		
		//Checking if the window is initialized correctly
		if (window == MemoryUtil.NULL) {
			throw new RuntimeException("ERROR: Sourcy is unable to initialize the GLFW Window!");
		}
		
		//Creating and initializing the GLFW videoMode
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		
		//Setting the window position
		GLFW.glfwSetWindowPos(window, (videoMode.width() - winWidth) / 2, (videoMode.height() - winHeight) / 2);
	}
	
	public void handleWindow() {
		while (!isClosed()) {
			//Handling the window
			GLFW.glfwSwapBuffers(window);
			GLFW.glfwPollEvents();
		}
	}
	
	public void show() {
		GLFW.glfwShowWindow(window);
	}
	
	public void hide() {
		GLFW.glfwHideWindow(window);
	}
	
	public void setResizable(boolean resizable) {
		if (resizable) {
			GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		}
		else {
			GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
		}
	}
	
	public int getWidth() {
		return winWidth;
	}
	
	public int getHeight() {
		return winHeight;
	}
	
	public String getTitle() {
		return winTitle;
	}
	
	public void setPosition(int xpos, int ypos) {
		GLFW.glfwSetWindowPos(window, xpos, ypos);
	}
	
	public void setSize(int WIDTH, int HEIGHT) {
		winWidth = WIDTH;
		winHeight = HEIGHT;
		GLFW.glfwSetWindowSize(window, WIDTH, HEIGHT);
	}
	
	public void setTitle(String TITLE) {
		winTitle = TITLE;
		GLFW.glfwSetWindowTitle(window, TITLE);
	}
	
	public boolean isClosed() {
		return GLFW.glfwWindowShouldClose(window);
	}
	
	public boolean isGLFWInitialized() {
		return inited;
	}
	
	public long getWindow() {
		return window;
	}
	
}