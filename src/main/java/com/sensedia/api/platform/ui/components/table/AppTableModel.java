package com.sensedia.api.platform.ui.components.table;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.table.DefaultTableModel;

import com.sensedia.api.platform.model.Docker;
import com.sensedia.api.platform.model.Docker.Status;

public class AppTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	private Vector<Docker> dockers;

	public AppTableModel(List<Docker> dockers) {
		super();
		this.dockers = new Vector<>(dockers);
		create();
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 1) {
			return Status.class;
		} else if (columnIndex == 3) {
			return ActionButtons.class;
		}
		return String.class;
	}

	private void create() {
		Vector<Object> columnIdentifiers = new Vector<>(Arrays.asList("Nome do docker", "Status", "Porta", "Ações"));
		Vector<Vector<Object>> dataVector = dockers.stream().map(
				it -> new Vector<Object>(Arrays.asList(it.getName(), it.getStatus(), it.getPorts(), ActionButtons.ALL)))
				.collect(Collectors.toCollection(Vector::new));
		setDataVector(dataVector, columnIdentifiers);
	}

	public Docker getData(int row) {
		return dockers.get(row);
	}
}
