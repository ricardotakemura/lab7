package com.sensedia.api.platform.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JWindow;

public class SplashWindow extends JWindow {

	private static final int THREE_SECONDS = 3000;
	private static final String IMAGE_SPLASH = "/images/splash.jpg";
	private static final int HEIGHT = 432;
	private static final int WIDTH = 768;
	private static final long serialVersionUID = 1L;
	private BufferedImage splashImage;
	private Dimension screenSize;
	private AppFrame appFrame;

	public SplashWindow(AppFrame appFrame) {
		this.appFrame = appFrame;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		init();
	}

	private void init() {
		try {
			splashImage = ImageIO.read(getClass().getResourceAsStream(IMAGE_SPLASH));
			setBounds((int) (screenSize.getWidth() - WIDTH) / 2, (int) (screenSize.getHeight() - HEIGHT) / 2, WIDTH,
					HEIGHT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		try {
			setVisible(true);
			Thread.sleep(THREE_SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			setVisible(false);
			if (appFrame != null) {
				appFrame.start();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.drawImage(splashImage, 0, 0, this.getWidth(), this.getHeight(), 0, 0, splashImage.getWidth(),
				splashImage.getHeight(), this);
	}

}
