package com.sensedia.api.platform.ui;

import com.sensedia.api.platform.model.Docker;

public abstract class AppAdapter {
	public abstract void onStartMenuItemClicked();

	public abstract void onRestartMenuItemClicked();

	public abstract void onStopMenuItemClicked();

	public void onExitMenuItemClicked() {
	}

	public void onAboutMenuItemClicked() {
	}

	public abstract void onStartButtonClicked(Docker docker);

	public abstract void onStopButtonClicked(Docker docker);

	public abstract void onEditButtonClicked(Docker docker);

	public abstract void onRunPipelineButtonClicked(Docker docker);

}
