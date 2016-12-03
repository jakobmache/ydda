package de.mobilityhacks.ydda.youdontdrivealone.social;

//This bar is supposed to represent the progress
public class Bar {
	
	int xpForPoints; //how many XP are needed to finish a task and therefore get the points
	double percentage;
	int currentXP;
	
	//constructor
	public Bar(int xpForPoints) {
		this.xpForPoints = xpForPoints;
	}
	
	//calculate the XP for the personal quest
	int calculateCurrentXPPersonal(You you) {
		//TODO How to calculate it?
		return currentXP;
	}
	
	//calclate the percentage
	public double getPercentage() {
		double onePercent = xpForPoints / 100.0;
		percentage = currentXP / onePercent;
		return percentage;
	}
	
	//find out the current XP for the quest and set it right
	void setCurrentXP() {
		//TODO wie kriegen wir die XP?
	}
	
	int getCurrentXP() {
		return currentXP;
	}
}
