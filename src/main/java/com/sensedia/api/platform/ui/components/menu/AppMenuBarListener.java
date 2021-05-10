package com.sensedia.api.platform.ui.components.menu;

import java.awt.event.ActionEvent;

public interface AppMenuBarListener {

	void onStartMenuItemClicked(ActionEvent e);

	void onRestartMenuItemClicked(ActionEvent e);

	void onStopMenuItemClicked(ActionEvent e);

	void onExitMenuItemClicked(ActionEvent e);

	void onAboutMenuItemClicked(ActionEvent e);
}
