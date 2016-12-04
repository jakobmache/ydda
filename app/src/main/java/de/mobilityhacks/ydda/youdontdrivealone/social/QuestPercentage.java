package de.mobilityhacks.ydda.youdontdrivealone.social;

import android.content.Context;

import de.mobilityhacks.ydda.youdontdrivealone.R;

/**
 *
 */

public class QuestPercentage extends Quest {
    String name;
    String description;
    String type;
    public QuestPercentage(Context context) {
        name = context.getResources().getString(R.string.questPercentage);
        name = context.getResources().getString(R.string.questPercentageDesc);
        //type = super.computeType();
    }
}
