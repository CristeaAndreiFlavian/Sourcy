package org.sourcy.glfw;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryUtil;
import org.sourcy.opentlb.OpenTLB01;
import org.sourcy.opentlb.TLB;
import org.sourcy.util.SV;
import org.sourcy.util.debug.DebugLogger;

public class SouGLFW implements SV, TLB {

	private static long window;
	private static int winWidth, winHeight;
	private static String winTitle;
	
	public SouGLFW(int WIDTH, int HEIGHT) {
		this.winWidth = WIDTH;
		this.winHeight = HEIGHT;
		this.winTitle = "Sourcy Addon";
	}
	
	public static void createWindow(long displayFPSInConsole) {
		SV.getVersion();
		TLB.getVersion();
		if (!isGLFWInitialized()) {
			throw new IllegalStateException("ERROR: Sourcy is unable to initialize GLFW!");
		}
		window = GLFW.glfwCreateWindow(winWidth, winHeight, winTitle, MemoryUtil.NULL, MemoryUtil.NULL);
		if (window == MemoryUtil.NULL) {
			throw new RuntimeException("ERROR: Sourcy is unable to initialize the GLFW Window!");
		}
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
		GLFW.glfwSetWindowPos(window, (videoMode.width() - winWidth) / 2, (videoMode.height() - winHeight) / 2);
		while (!isClosed()) {
			handleWindow();
			if (displayFPSInConsole == OpenTLB01.TLB_TRUE_LONG) {
				DebugLogger.customInfo("FPS: "+OpenTLB01.getFPS(), 000000000);
			}
			if (isClosed()) {
				closeWindow(0);
			}
		}
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
	
	private static void handleWindow() {
		GLFW.glfwSwapBuffers(window);
		GLFW.glfwPollEvents();
	}
	
	public static long getWindow() {
		return window;
	}
	
}