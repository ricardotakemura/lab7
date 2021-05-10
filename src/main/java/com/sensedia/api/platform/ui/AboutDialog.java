package com.sensedia.api.platform.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AboutDialog {

	private static final String TITLE = "Sobre";
	private static final String MESSAGE = "API Platform Starter - Sensedia (c) 2021";
	private JFrame parent;
	private static AboutDialog instance; 
	
	private AboutDialog(JFrame parent) {
		this.parent = parent;
	}
	
	public static AboutDialog getInstance(JFrame parent) {		
		if (instance == null) {
			instance = new AboutDialog(parent);
		}
		return instance; 
	}

	public void show() {
		JOptionPane.showMessageDialog(parent, MESSAGE, TITLE,
				JOptionPane.INFORMATION_MESSAGE);
	}

}
