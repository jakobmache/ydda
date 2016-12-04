package de.mobilityhacks.ydda.youdontdrivealone.social;

import android.content.Context;

/**
 *
 */

public class QuestCreate {
    Context context;
    public QuestCreate(Context context) {
        this.context = context;
    }
    public Quest createQuest(Context context) {
        int n = Quest.getN();
        if (n%3 == 0) {
            return new QuestAvg(context);
        }
        else if (n%3 == 1) {
            return new QuestKms(context);
        }
        else {
            return new QuestPercentage(context);
        }
    }
}
