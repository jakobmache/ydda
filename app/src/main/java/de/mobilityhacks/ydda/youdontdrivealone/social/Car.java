package de.mobilityhacks.ydda.youdontdrivealone;

//representing the cars that can be rented
public class Car {
	String brand;
	String name;
	//TODO Kriterien und so..
	double consumptionPerKm;
	String fuel;
	double distanceTravelled;
	double fuelUsed;
	
	public Car(String brand, String name, double consumptionPerKm, String fuel) {
		this.brand = brand;
		this.name = name;
		this.consumptionPerKm = consumptionPerKm;
		this.fuel = fuel;
	}
	
	//because of lack of a real source we just simulate a drive
	//you can imagine that the real values are tracked and the calculation
	//can happen in this method instead
	public void drive(double distanceTravelled, double fuelUsed) {
		this.distanceTravelled = distanceTravelled;
		this.fuelUsed = fuelUsed;
	}
}
