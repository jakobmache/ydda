package de.mobilityhacks.ydda.youdontdrivealone.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.mobilityhacks.ydda.youdontdrivealone.R;

public class DrivingFr  extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                 Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_driving, container, false);

        //Should be linked with quest here
        ((ProgressBar) view.findViewById(R.id.progress_bar_driving)).setProgress(33);
        ((TextView) view.findViewById(R.id.title_driving)).setText("Quest - single");
        ((TextView) view.findViewById(R.id.subtext_driving)).setText("Progress: 33%");

        return view;
    }
}
