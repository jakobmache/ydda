package de.mobilityhacks.ydda.youdontdrivealone.backend.quests;

import java.util.TimerTask;

import de.mobilityhacks.ydda.youdontdrivealone.backend.persons.Person;

public class QuestUpdater extends TimerTask{

    public float intervalInMin = 0.5F;
    private Quest[] quests;

    public QuestUpdater(Quest... quests) {
        this.quests = quests;
    }

    @Override
    public void run(){
        for (Quest quest:quests) {
            for (Person person:quest.getPersonsAssignedTo()) {
                //Here we should extend later
                //Go through all quests and update progress
            }
        }
    }
}
