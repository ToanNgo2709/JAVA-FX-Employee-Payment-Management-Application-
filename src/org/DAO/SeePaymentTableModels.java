package org.DAO;

public class SeePaymentTableModels {
	String client_name, project_name, task_name;
	float workHour;
	int payHour;

	public SeePaymentTableModels(String client_name, String project_name, String task_name, float workHour,
			int payHour) {
		super();
		this.client_name = client_name;
		this.project_name = project_name;
		this.task_name = task_name;
		this.workHour = workHour;
		this.payHour = payHour;
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

	public float getWorkHour() {
		return workHour;
	}

	public void setWorkHour(float workHour) {
		this.workHour = workHour;
	}

	public int getPayHour() {
		return payHour;
	}

	public void setPayHour(int payHour) {
		this.payHour = payHour;
	}

}
