package com.sensedia.api.platform.ui.components.table;

import com.sensedia.api.platform.model.Docker;

public interface AppTableListener {
	void onStartButtonClicked(Docker docker);

	void onStopButtonClicked(Docker docker);

	void onEditButtonClicked(Docker docker);

	void onRunPipelineButtonClicked(Docker docker);
}
