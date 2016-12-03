package de.mobilityhacks.ydda.youdontdrivealone.social;

/**
 *
 */

public class QuestKms extends Quest {
    String name;
    String description;
    String type;
    public QuestKms() {
        name = "@string/QuestKms";
        description = "@string/QuestKmsDesc";
        type = Quest.computeType();
    }
}
