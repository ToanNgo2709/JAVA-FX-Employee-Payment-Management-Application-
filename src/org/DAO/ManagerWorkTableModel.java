package org.DAO;

public class ManagerWorkTableModel {
	String client_name, project_name, task_name, comment, status;
	float noOfHour;

	public ManagerWorkTableModel(String client_name, String project_name, String task_name, String comment,
			String status, Float noOfHour) {
		super();
		this.client_name = client_name;
		this.project_name = project_name;
		this.task_name = task_name;
		this.comment = comment;
		this.status = status;
		this.noOfHour = noOfHour;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getNoOfHour() {
		return noOfHour;
	}

	public void setNoOfHour(float noOfHour) {
		this.noOfHour = noOfHour;
	}

}
