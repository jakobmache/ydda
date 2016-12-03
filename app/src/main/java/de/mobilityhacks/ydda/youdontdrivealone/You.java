package de.mobilityhacks.ydda.youdontdrivealone;

public class You {
	int points;
	PersonalQuest personalQuest;
	Car rentedCar;
	
	public You() {
		points = 0;
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
