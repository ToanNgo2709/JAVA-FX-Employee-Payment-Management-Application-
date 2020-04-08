package org.DAO;

public class PaymentManagerTableModels {
	int id;
	String name;
	float workTime, offTime, wages, tax, Total;

	public PaymentManagerTableModels(int id, String name, float workTime, float offTime, float wages, float tax,
			float total) {
		super();
		this.id = id;
		this.name = name;
		this.workTime = workTime;
		this.offTime = offTime;
		this.wages = wages;
		this.tax = tax;
		Total = total;
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

	public float getWorkTime() {
		return workTime;
	}

	public void setWorkTime(float workTime) {
		this.workTime = workTime;
	}

	public float getOffTime() {
		return offTime;
	}

	public void setOffTime(float offTime) {
		this.offTime = offTime;
	}

	public float getWages() {
		return wages;
	}

	public void setWages(float wages) {
		this.wages = wages;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

}
