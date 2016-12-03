package de.mobilityhacks.ydda.youdontdrivealone.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import de.mobilityhacks.ydda.youdontdrivealone.R;

/**
 *
 */

public class QuestsFr extends Fragment{
    ProgressDialog progressBar;
    int progress = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.quests_layout, container, false);
    }

}
