package de.mobilityhacks.ydda.youdontdrivealone.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.mobilityhacks.ydda.youdontdrivealone.MainActivity;
import de.mobilityhacks.ydda.youdontdrivealone.R;
import de.mobilityhacks.ydda.youdontdrivealone.backend.persons.Person;
import de.mobilityhacks.ydda.youdontdrivealone.backend.quests.Quest;
import de.mobilityhacks.ydda.youdontdrivealone.backend.quests.QuestFactory;

/**
 *
 */

public class QuestsFr extends Fragment{

    public static final String TAG = QuestsFr.class.getName();

    public TextView name;
    public TextView desc;
    ProgressDialog progressBar;
    int progress = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View viewInflate = inflater.inflate(R.layout.quests_layout, container, false);

        Quest privateQuest = QuestFactory.createRandomQuest(getContext(), Quest.TYPE_SINGLE);
        Quest friendsQuest = QuestFactory.createRandomQuest(getContext(), Quest.TYPE_SOCIAL);

        privateQuest.addPerson(((MainActivity) getActivity()).getYou());
        friendsQuest.addPerson(((MainActivity) getActivity()).getYou());

        //It's a quest for all - normally we need more checks here and more quests
        if (((MainActivity)getActivity()).getPersons() != null){
            for (Person person :((MainActivity) getActivity()).getPersons()) {
                friendsQuest.addPerson(person);
            }
        }

        View privateLayout = inflater.inflate(R.layout.layout_quest, (LinearLayout)
                viewInflate.findViewById(R.id.quests_container), false);
        View socialLayout = inflater.inflate(R.layout.layout_quest, (LinearLayout)
                viewInflate.findViewById(R.id.quests_container), false);

        ((TextView) privateLayout.findViewById(R.id.quest_title)).setText(friendsQuest.getName());
        ((TextView) socialLayout.findViewById(R.id.quest_title)).setText(friendsQuest.getName());

        ((TextView) privateLayout.findViewById(R.id.quest_description)).setText(friendsQuest.getDescription());
        ((TextView) socialLayout.findViewById(R.id.quest_description)).setText(friendsQuest.getDescription());

        ((LinearLayout) viewInflate.findViewById(R.id.quests_container)).addView(privateLayout);
        ((LinearLayout) viewInflate.findViewById(R.id.quests_container)).addView(socialLayout);
        return viewInflate;
    }
}
