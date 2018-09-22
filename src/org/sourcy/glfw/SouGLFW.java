package org.sourcy.glfw;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;
import org.sourcy.opentlb.TLB1;
import org.sourcy.opentlb.TLB;
import org.sourcy.util.SV;
import org.sourcy.util.debug.DebugLogger;

public class SouGLFW implements SV, TLB {

	private static long window;
	private static int winWidth, winHeight;
	private static String winTitle;
	
	//Constructor
	public SouGLFW(int WIDTH, int HEIGHT) {
		this.winWidth = WIDTH;
		this.winHeight = HEIGHT;
		this.winTitle = "Sourcy Addon";
	}
	
	public static void createWindow(long displayFPSInConsole) {
		//Getting versions of Sourcy and other things.
		DebugLogger.logInfo(Version.getVersion());
		SV.getVersion();
		TLB.getVersion();
		
		//Checking if GLFW is initialized
		if (!isGLFWInitialized()) {
			throw new IllegalStateException("ERROR: Sourcy is unable to initialize GLFW!");
		}
		
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
		
		//Showing the window
		GLFW.glfwShowWindow(window);
		
		//Handling the window
		while (!isClosed()) {
			handleWindow();
			
			//Checking if the long is "999999999"
			if (displayFPSInConsole == TLB1.TLB_TRUE_LONG) {
				DebugLogger.customInfo("FPS: "+TLB1.getFPS(), 000000000);
			}
			
			//Checking when the window is closed
			if (isClosed()) {
				closeWindow(0);
			}
		}
	}
	
	private static void handleWindow() {
		GLFW.glfwSwapBuffers(window);
		GLFW.glfwPollEvents();
	}
	
	public static void show(int visible) {
		if (visible == TLB1.TLB_TRUE_INT) {
			GLFW.glfwShowWindow(window);
		}
		if (visible == TLB1.TLB_FALSE_INT) {
			GLFW.glfwShowWindow(0);
		}
	}
	
	public static void setResizable(int resizable) {
		if (resizable == TLB1.TLB_TRUE_INT) {
			GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
		}
		if (resizable == TLB1.TLB_FALSE_INT) {
			GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
		}
	}
	
	public static void setPosition(int xpos, int ypos) {
		GLFW.glfwSetWindowPos(ypos, xpos, ypos);
	}
	
	public static void setSize(int WIDTH, int HEIGHT) {
		winWidth = WIDTH;
		winHeight = HEIGHT;
		GLFW.glfwSetWindowSize(window, WIDTH, HEIGHT);
	}
	
	public static void setTitle(String TITLE) {
		winTitle = TITLE;
		GLFW.glfwSetWindowTitle(window, TITLE);
	}
	
	public static boolean isClosed() {
		return GLFW.glfwWindowShouldClose(window);
	}
	
	public static boolean isGLFWInitialized() {
		return GLFW.glfwInit();
	}
	
	public static void closeWindow(int status) {
		System.exit(status);
	}
	
	public static long getWindow() {
		return window;
	}
	
}