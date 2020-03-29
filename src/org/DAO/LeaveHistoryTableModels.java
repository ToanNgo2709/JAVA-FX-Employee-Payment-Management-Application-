package org.DAO;

public class LeaveHistoryTableModels {
	String type, reason, status;
	Float noHour;

	public LeaveHistoryTableModels(String type, String reason, String status, Float noHour) {
		super();
		this.type = type;
		this.reason = reason;
		this.status = status;
		this.noHour = noHour;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getNoHour() {
		return noHour;
	}

	public void setNoHour(Float noHour) {
		this.noHour = noHour;
	}

}
