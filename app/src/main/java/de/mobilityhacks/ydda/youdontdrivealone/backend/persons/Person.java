package de.mobilityhacks.ydda.youdontdrivealone.backend.persons;

import java.util.HashMap;
import java.util.Map;

import de.mobilityhacks.ydda.youdontdrivealone.backend.quests.Quest;

public class Person {

	private String name;
	private String userID;

    //Quest -> completed?
	private Map<Quest, Boolean> activeQuests;

    //Quest -> XP the person has
    private Map<Quest, Integer> questXps;

	private int absoluteXp = 0;
    private float absolutePoints = 0;

    public Person(String name, String userID) {
        this.name = name;
        this.userID = userID;

        activeQuests = new HashMap<>();
        questXps = new HashMap<>();
    }

	public void addQuest(Quest quest) {
		activeQuests.put(quest, false);
        questXps.put(quest, 0);
	}

    public void completeQuest(Quest quest) {
        activeQuests.put(quest, true);
        questXps.put(quest, quest.getXp());

        //Did every friend complete this quest if it is social?
        if (quest.getType().equals(Quest.TYPE_SOCIAL)) {
            for (Person person:quest.getPersonsAssignedTo()) {
                if (!person.getActiveQuests().get(quest))
                    return;
            }
        }

        activeQuests.remove(quest);
        questXps.remove(quest);

        absoluteXp += quest.getXp();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getAbsoluteXp() {
		return absoluteXp;
	}

	public void setAbsoluteXp(int absoluteXp) {
		this.absoluteXp = absoluteXp;
	}

    public Map<Quest, Boolean> getActiveQuests() {
        return activeQuests;
    }

	public void setActiveQuests(Map<Quest, Boolean> activeQuests) {
		this.activeQuests = activeQuests;
	}
}
