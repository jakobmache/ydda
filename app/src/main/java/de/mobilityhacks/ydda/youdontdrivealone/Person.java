package de.mobilityhacks.ydda.youdontdrivealone;

public class Person {
	String name;
	// TODO facebook-ID
	FriendQuest friendQuest;
	int absoluteXP;
	
	void setFriendQuest(String name, String decription, int xpForPoints, int pointValue) {
		friendQuest = new FriendQuest(name, decription, xpForPoints, pointValue);
	}

}
