package de.mobilityhacks.ydda.youdontdrivealone.social;

/**
 *
 */

public class QuestAvg extends Quest {
    String name;
    String description;
    String type;
    public QuestAvg() {
        name = "@string/QuestAvg";
        description = "@string/QuestAvgDesc";
        type = super.computeType();
    }
}
