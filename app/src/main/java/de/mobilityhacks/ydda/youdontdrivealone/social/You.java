package de.mobilityhacks.ydda.youdontdrivealone.social;

public class You {
	int points;
	PersonalQuest personalQuest;
	Car rentedCar;
	int currentXP;
	
	public You() {
		points = 0;
		currentXP = 0;
	}
	
	void setCurrentXP() {
		currentXP = getPersonalQuest().getBar().getCurrentXP() + getFriendQuest().getBar().getCurrentXP();
	}
	
	void completePersonalQuest(String name, String description, int xpForPoints, int pointValue) {
		points = points + getPersonalQuest().getPointValue();
		setPersonalQuest(name, description, xpForPoints, pointValue);
	}
	
	PersonalQuest getPersonalQuest() {
		return personalQuest;
	}
	
	void setPersonalQuest(String name, String description, int xpForPoints, int pointValue) {
		this.personalQuest = new PersonalQuest(name, description, xpForPoints, pointValue);
	}
	
	FriendQuest getFriendQuest() {
		return getFriendQuest();
	}
	
	void setFriendQuest(String name, String description, int xpForPoints, int pointValue) {
		this.setFriendQuest(name, description, xpForPoints, pointValue);
	}
	
	void completeFriendQuest(String name, String description, int xpForPoints, int pointValue) {
		points = points + getFriendQuest().getPointValue();
		setFriendQuest(name, description, xpForPoints, pointValue);
	}
}
