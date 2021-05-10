package com.sensedia.api.platform.ui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import com.sensedia.api.platform.model.Docker;
import com.sensedia.api.platform.model.Docker.Status;
import com.sensedia.api.platform.ui.components.table.ActionButtons;
import com.sensedia.api.platform.ui.components.table.AppTableListener;
import com.sensedia.api.platform.ui.components.table.AppTableModel;

public class AppTable extends JTable {

	private static final int ACTIONS_COLUMN_WIDTH = 300;
	private static final int ACTIONS_COLUMN = 3;
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 36;
	private AppTableListener listener;

	public AppTable(List<Docker> dockers, AppTableListener listener) {
		super(new AppTableModel(dockers));
		this.listener = listener;
		create();
	}

	public void setData(List<Docker> dockers) {
		setModel(new AppTableModel(dockers));
	}

	private void create() {
		setRowHeight(HEIGHT);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		setDefaultRenderer(Object.class, renderer);
		setDefaultRenderer(Status.class, this::rendererStatus);
		setDefaultRenderer(ActionButtons.class, this::rendererActionButtons);
		getColumnModel().getColumn(ACTIONS_COLUMN).setMinWidth(ACTIONS_COLUMN_WIDTH);
	}

	private Component rendererActionButtons(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		JPanel panel = new JPanel(new FlowLayout());
		JButton startButton = new JButton("Iniciar");
		AppTableModel model = (AppTableModel) table.getModel();
		panel.add(startButton);
		JButton stopButton = new JButton("Parar");
		panel.add(stopButton);
		JButton editButton = new JButton("Editar");
		panel.add(editButton);
		JButton pipelineButton = new JButton("Rodar pipeline");
		panel.add(pipelineButton);
		if (listener != null) {
			startButton.addActionListener(e -> listener.onStartButtonClicked(model.getData(row)));
			stopButton.addActionListener(e -> listener.onStopButtonClicked(model.getData(row)));
			editButton.addActionListener(e -> listener.onEditButtonClicked(model.getData(row)));
			pipelineButton.addActionListener(e -> listener.onRunPipelineButtonClicked(model.getData(row)));
		}
		return panel;
	}

	private Component rendererStatus(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		Status status = (Status) value;
		JLabel label = new JLabel(status.name());
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		switch (status) {
		case STARTED:
			label.setBackground(Color.GREEN);
			label.setForeground(Color.BLACK);
			break;
		case STOPPED:
			label.setBackground(Color.RED);
			label.setForeground(Color.BLACK);
			break;
		case DEAD:
			label.setBackground(Color.BLACK);
			label.setForeground(Color.WHITE);
			break;
		default:
			label.setBackground(Color.YELLOW);
			label.setForeground(Color.BLACK);
			break;
		}
		return label;
	}

}