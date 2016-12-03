package de.mobilityhacks.ydda.youdontdrivealone.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.mobilityhacks.ydda.youdontdrivealone.R;

/**
 *
 */

public class RankingFr extends ListFragment
{

    public static final String TAG = RankingFr.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ranking, container, false);

        Log.d(TAG, "Container " + container.toString());

        return view;
    }
}
