package de.mobilityhacks.ydda.youdontdrivealone;

public class PersonalQuest extends Quest {
	
	public PersonalQuest(String name, String description, int xpForPoints, int pointValue) {
		this.name = name;
		this.description = description;
		bar = new Bar(xpForPoints);
		this.pointValue = pointValue;
	}
	
}
