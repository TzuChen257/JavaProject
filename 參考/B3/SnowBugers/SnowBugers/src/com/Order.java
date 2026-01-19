package com;

public class Order {

	private int rocketBuger;
	private int fries;
	private int onionRings;
	private double sum;
	private boolean setMeal;

	public Order(int rocketBuger, int fries, int onionRings, boolean setMeal) {
		super();
		this.rocketBuger = rocketBuger;
		this.fries = fries;
		this.onionRings = onionRings;
		this.sum = this.rocketBuger * 180 + this.fries * 70 + this.onionRings * 70;
		this.setMeal=setMeal;
		if (setMeal)
			sum = sum + 70;
	}

	public int getRocketBuger() {
		return rocketBuger;
	}

	public void setRocketBuger(int rocketBuger) {
		this.rocketBuger = rocketBuger;
	}

	public int getFries() {
		return fries;
	}

	public void setFries(int fries) {
		this.fries = fries;
	}

	public int getOnionRings() {
		return onionRings;
	}

	public void setOnionRings(int onionRings) {
		this.onionRings = onionRings;
	}

	public boolean isSetMeal() {
		return setMeal;
	}

	public void setSetMeal(boolean setMeal) {
		this.setMeal = setMeal;
	}

	public double getSum() {
		return sum;
	}

}
