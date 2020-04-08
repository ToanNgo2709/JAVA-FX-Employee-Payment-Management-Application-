package org.DAO;

public class LeaveManagerTableModels {
	int id;
	String name, type, reason;
	float noHour;

	public LeaveManagerTableModels(int id, String name, String type, String reason, float noHour) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.reason = reason;
		this.noHour = noHour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public float getNoHour() {
		return noHour;
	}

	public void setNoHour(float noHour) {
		this.noHour = noHour;
	}

}
