package de.mobilityhacks.ydda.youdontdrivealone;

public class Bar {
	int xpForPoints;
	double percentage;
	int currentXP;
	
	public Bar(int xpForPoints) {
		this.xpForPoints = xpForPoints;
	}
	
	int calculateCurrentXPPersonal(You you) {
		//TODO How to calculate it?
		return currentXP;
	}
	
	public double getPercentage() {
		double onePercent = xpForPoints / 100.0;
		percentage = currentXP / onePercent;
		return percentage;
	}
}
