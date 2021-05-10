package com.sensedia.api.platform.model;

public class Docker {

	public enum Status {
		INIT, STARTED, STOPPED, DEAD
	}

	private String name;
	private Status status;
	private String ports;

	public Docker(String name, Status status, String ports) {
		super();
		this.name = name;
		this.status = status;
		this.ports = ports;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPorts() {
		return ports;
	}

	public void setPorts(String ports) {
		this.ports = ports;
	}

}
