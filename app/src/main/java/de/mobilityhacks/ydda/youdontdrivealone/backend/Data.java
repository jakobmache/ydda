package de.mobilityhacks.ydda.youdontdrivealone.backend;

import java.util.ArrayList;
import de.mobilityhacks.ydda.youdontdrivealone.backend.Car;

public class Data {
	
	ArrayList<Car> carData = new ArrayList<Car>();
	
	Car audiA4B = new Car("Audi", "A4", 5.2, "Gas");
	Car fiat500B = new Car("Fiat", "500", 3.8, "Gas");
	Car seatLeonB = new Car("Seat", "leon", 5.8, "Gas");
	Car smartFouTwoB = new Car("Smart", "FourTwo", 4.4, "Gas");
	Car VWGolfB = new Car("VW", "Golf", 4.6, "Gas");
	Car VWGolfD = new Car("VW", "Golf", 3.8, "Diesel");
	
}
