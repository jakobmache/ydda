package de.mobilityhacks.ydda.youdontdrivealone.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.mobilityhacks.ydda.youdontdrivealone.R;

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

        TextView v = (TextView) viewInflate.findViewById(R.id.quest);
        //Quest q = QuestCreate.createQuest(getContext());

        //v.setText(q.getName() + "" + q.getDesc());

        //v.setText("aaaaaaaaaaaa");
        return viewInflate;
    }
    public TextView t() {
        TextView v = (TextView) getView().findViewById(R.id.quest);
        return v;
    }
    /*public void showQuests() {
        Quest q = QuestCreate.createQuest();
        View test = getView().findViewById(R.id.quest);
        TextView test2 = (TextView) test;
        test2.setText(q.getName());
    }*/
}
