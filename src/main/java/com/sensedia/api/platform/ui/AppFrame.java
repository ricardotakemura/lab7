package com.sensedia.api.platform.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Collections;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sensedia.api.platform.model.Docker;
import com.sensedia.api.platform.model.Docker.Status;
import com.sensedia.api.platform.ui.components.AppMenuBar;
import com.sensedia.api.platform.ui.components.AppTable;
import com.sensedia.api.platform.ui.components.menu.AppMenuBarListener;
import com.sensedia.api.platform.ui.components.table.AppTableListener;
import com.sensedia.api.platform.util.AppProperties;

public class AppFrame extends JFrame implements AppTableListener, AppMenuBarListener {

	private static final String DOCKER_TYPES = "application.platform.docker.types";
	private static final String TITLE = "API Platform Starter";
	private static final long serialVersionUID = 1L;
	private AppProperties appProperties;
	private Dimension screenSize;
	private AppTable processTable;
	private AppMenuBar menuBar;
	private JComboBox<String> typeComboBox;
	private AppAdapter adapter;

	public AppFrame() {
		appProperties = AppProperties.getInstance();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		init();
	}
	
	public void setAdapter(AppAdapter adapter) {
		this.adapter = adapter;
	}

	private void init() {
		setTitle(TITLE);
		setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		menuBar = new AppMenuBar(this, this);
		this.setJMenuBar(menuBar);
		setLayout(new BorderLayout());
		processTable = new AppTable(Collections.singletonList(new Docker("api-manager",Status.STARTED, "8001,8081")), this);
		add(new JScrollPane(processTable), BorderLayout.CENTER);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(new JLabel("Tipo dos dockers: "));		
		typeComboBox = new JComboBox<>(appProperties.getPropertyAsArray(DOCKER_TYPES));
		topPanel.add(typeComboBox);
		add(topPanel, BorderLayout.NORTH);
	}
	
	public void start() {
		setVisible(true);
	}

	@Override
	public void onStartMenuItemClicked(ActionEvent e) {
		if (adapter != null) {
			adapter.onStartMenuItemClicked();
		}		
	}

	@Override
	public void onRestartMenuItemClicked(ActionEvent e) {
		if (adapter != null) {
			adapter.onRestartMenuItemClicked();
		}
	}

	@Override
	public void onStopMenuItemClicked(ActionEvent e) {
		if (adapter != null) {
			adapter.onStopMenuItemClicked();
		}
		
	}

	@Override
	public void onExitMenuItemClicked(ActionEvent e) {
		if (adapter != null) {
			adapter.onExitMenuItemClicked();
		}
	}

	@Override
	public void onAboutMenuItemClicked(ActionEvent e) {
		if (adapter != null) {
			adapter.onAboutMenuItemClicked();
		}
		
	}

	@Override
	public void onStartButtonClicked(Docker docker) {
		if (adapter != null) {
			adapter.onStartButtonClicked(docker);
		}		
	}

	@Override
	public void onStopButtonClicked(Docker docker) {
		if (adapter != null) {
			adapter.onStopButtonClicked(docker);
		}		
	}

	@Override
	public void onEditButtonClicked(Docker docker) {
		if (adapter != null) {
			adapter.onEditButtonClicked(docker);
		}		
	}

	@Override
	public void onRunPipelineButtonClicked(Docker docker) {
		if (adapter != null) {
			adapter.onRunPipelineButtonClicked(docker);
		}		
	}

}
