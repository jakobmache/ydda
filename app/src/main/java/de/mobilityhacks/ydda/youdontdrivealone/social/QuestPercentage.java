package de.mobilityhacks.ydda.youdontdrivealone.social;


public class QuestPercentage extends Quest {
    String name;
    String description;
    String type;
    public QuestPercentage() {
        name="@string/QuestPercentage";
        description = "@string/QuestPercentageDesc";
        type = Quest.computeType();
    }
}
