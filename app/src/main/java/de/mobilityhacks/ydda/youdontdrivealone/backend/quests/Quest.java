package de.mobilityhacks.ydda.youdontdrivealone.backend.quests;

//quests in general (super class for personal quest and friend quest)


import java.util.ArrayList;
import java.util.List;

import de.mobilityhacks.ydda.youdontdrivealone.backend.persons.Person;

public abstract class Quest {

    public static final String TYPE_SOCIAL = "social";
    public static final String TYPE_SINGLE = "single";

    public static final int SOCIAL_MULTIPLIER = 2;

    private String name;
	private String description;
    private String type;

    private int xp;

    private List<Person> personsAssignedTo = new ArrayList<>();

    public Quest(String name, String description, int xp, String type)
    {
        this.name = name;
        this.description = description;
        this.xp = xp;
        this.type = type;
    }

    public void addPerson(Person person) {
        personsAssignedTo.add(person);
    }

    public abstract void calcResults();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getXp() {
        return  type.equals(TYPE_SOCIAL) ? xp * SOCIAL_MULTIPLIER : xp ;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public List<Person> getPersonsAssignedTo() {
        return personsAssignedTo;
    }

    public void setPersonsAssignedTo(List<Person> personsAssignedTo) {
        this.personsAssignedTo = personsAssignedTo;
    }


}
