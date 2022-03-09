package ooit;

public class Car {

	private int productionYear = 2022;
	private double fuelAmount;
	private boolean locked = true;
	
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public double getFuelAmount() {
		return fuelAmount;
	}

	public void setProductionYear(int productionYear) {
		if (productionYear > 1900) {
			this.productionYear = productionYear;
		}
	}
	
	public int getProductionYear() {
		return this.productionYear;
	}
	
	public void addFuel(double additionalFuel) {
		this.fuelAmount = this.fuelAmount + additionalFuel;
	}
}
