package de.mobilityhacks.ydda.youdontdrivealone.social;

import android.content.Context;

import de.mobilityhacks.ydda.youdontdrivealone.MainActivity;
import de.mobilityhacks.ydda.youdontdrivealone.R;

import static java.security.AccessController.getContext;

/**
 *
 */

public class QuestAvg extends Quest {
    String name;
    String description;
    String type;
    public QuestAvg(Context context) {
        name = context.getResources().getString(R.string.questAvg);
        description = context.getResources().getString(R.string.questAvgDesc);
        //type = super.computeType();
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return description;
    }
}
