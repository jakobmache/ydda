package de.mobilityhacks.ydda.youdontdrivealone.backend.quests;


import android.content.Context;

import java.util.Random;

import de.mobilityhacks.ydda.youdontdrivealone.R;

public class QuestFactory
{

    public static Quest createRandomQuest(Context context, String type) {
        Random random = new Random();
        int randomNumber = random.nextInt(300);
        random.setSeed(System.currentTimeMillis());

        if (randomNumber < 100) {
            return new QuestAvg(context.getResources().getString(R.string.questAvg),
                    context.getResources().getString(R.string.questAvgDesc)
                    .replace("X", Integer.toString(new Random().nextInt(10) + 80)),
                    random.nextInt(10) + 10,
                    type
            );
        }
        else if (randomNumber < 200) {
            return new QuestKms(context.getResources().getString(R.string.questKms),
                    context.getResources().getString(R.string.questKmsDesc)
                    .replace("X", Integer.toString(new Random().nextInt(30))),
                    random.nextInt(10) + 10,
                    type
            );
        }
        else {
            return new QuestPercentage(context.getResources().getString(R.string.questPercentage),
                    context.getResources().getString(R.string.questPercentageDesc)
                    .replace("X", Integer.toString(new Random().nextInt(20))),
                    random.nextInt(10) + 10,
                    type
            );
        }
    }
}
