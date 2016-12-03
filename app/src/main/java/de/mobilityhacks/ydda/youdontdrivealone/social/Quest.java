package de.mobilityhacks.ydda.youdontdrivealone.social;

import java.util.Random;

import de.mobilityhacks.ydda.youdontdrivealone.social.Bar;

//quests in general (super class for personal quest and friend quest)
public class Quest {
	String name;
	String description = null;
	Bar bar;
    public Quest() {
        factory();
    }

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
    public Quest factory() {
        Random r = new Random();
        double q = r.nextDouble();
        if (q < 0.33) {
            return new QuestAvg();
        }
        else if (q < 0.67) {
            return new QuestKms();
        }
        else {
            return new QuestPercentage();
        }
    }
}
