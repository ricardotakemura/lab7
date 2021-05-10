package com.sensedia.api.platform.ui.components;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.sensedia.api.platform.ui.AboutDialog;
import com.sensedia.api.platform.ui.components.menu.AppMenuBarListener;

public class AppMenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private AboutDialog aboutDialog;
	private JMenuItem startMenuItem;
	private JMenuItem restartMenuItem;
	private JMenuItem stopMenuItem;
	private JMenuItem exitMenuItem;
	private JMenuItem aboutMenuItem;
	private AppMenuBarListener listener;

	public AppMenuBar(JFrame mainFrame, AppMenuBarListener listener) {
		super();
		aboutDialog = AboutDialog.getInstance(mainFrame);
		this.listener = listener;
		create();
		prepareListeners();
	}

	private void create() {
		JMenu processMenu = new JMenu("Processo");
		processMenu.setMnemonic('P');
		startMenuItem = new JMenuItem("Iniciar aplicações", 'I');
		startMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		processMenu.add(startMenuItem);
		restartMenuItem = new JMenuItem("Reiniciar aplicações", 'R');
		restartMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		processMenu.add(restartMenuItem);
		stopMenuItem = new JMenuItem("Parar aplicações", 'P');
		stopMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
		processMenu.add(stopMenuItem);
		exitMenuItem = new JMenuItem("Sair", 'S');
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		processMenu.add(exitMenuItem);
		this.add(processMenu);
		JMenu aboutMenu = new JMenu("Sobre");
		aboutMenu.setMnemonic('S');
		aboutMenuItem = new JMenuItem("Sobre...");
		aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		aboutMenu.add(aboutMenuItem);
		this.add(aboutMenu);
	}

	private void prepareListeners() {
		if (listener != null) {
			startMenuItem.addActionListener(listener::onStartMenuItemClicked);
			restartMenuItem.addActionListener(listener::onRestartMenuItemClicked);
			stopMenuItem.addActionListener(listener::onStopMenuItemClicked);
		}
		exitMenuItem.addActionListener((e) -> {
			if (listener != null) {
				listener.onExitMenuItemClicked(e);
			}
			System.exit(0);
		});
		aboutMenuItem.addActionListener((e) -> {
			if (listener != null) {
				listener.onAboutMenuItemClicked(e);
			}
			aboutDialog.show();
		});
	}

}
