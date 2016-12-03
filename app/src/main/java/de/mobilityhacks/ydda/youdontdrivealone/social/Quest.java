package de.mobilityhacks.ydda.youdontdrivealone.social;

import de.mobilityhacks.ydda.youdontdrivealone.social.Bar;

//quests in general (super class for personal quest and friend quest)
public class Quest {
	String name;
	String description;
	Bar bar;
	int pointValue; //how many points do you get for completing this quest
	
	int getPointValue() {
		return pointValue;
	}
	
	Bar getBar() {
		return bar;
	}
	
	//for progressbar in android (theoretically)
	void update() {
		getBar().setCurrentXP();
	}
}
