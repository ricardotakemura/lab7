package com.sensedia.api.platform;

import com.sensedia.api.platform.ui.AppFrame;
import com.sensedia.api.platform.ui.SplashWindow;

public class App {
	
	public void start() {
		SplashWindow splashWindow = new SplashWindow(new AppFrame());
		splashWindow.start();
	}
	
	public static void main(String... args) {
		App app = new App();
		app.start();
	}
}
