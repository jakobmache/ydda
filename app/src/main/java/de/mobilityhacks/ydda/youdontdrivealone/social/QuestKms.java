package de.mobilityhacks.ydda.youdontdrivealone.social;

import android.content.Context;

import de.mobilityhacks.ydda.youdontdrivealone.R;

/**
 *
 */

public class QuestKms extends Quest {
    String name;
    String description;
    String type;
    public QuestKms(Context context) {
        name = context.getResources().getString(R.string.questKms);
        description = context.getResources().getString(R.string.questKmsDesc);
        //type = super.computeType();
    }
}
