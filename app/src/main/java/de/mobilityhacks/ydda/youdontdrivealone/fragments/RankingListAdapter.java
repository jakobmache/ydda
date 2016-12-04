package de.mobilityhacks.ydda.youdontdrivealone.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.mobilityhacks.ydda.youdontdrivealone.R;
import de.mobilityhacks.ydda.youdontdrivealone.backend.persons.Person;
import de.mobilityhacks.ydda.youdontdrivealone.utils.ProfilePictureView;

public class RankingListAdapter extends BaseAdapter {

    public static final String TAG = RankingListAdapter.class.getName();
    private Context context;

    private List<Person> items = new ArrayList<>();

    public RankingListAdapter(Context context) {
        super();
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "Try to get view at position " + position);
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.ranking_menu_item, null);
        }

        ProfilePictureView profilePictureView = (ProfilePictureView) convertView.findViewById(
                R.id.ranking_picture);
        profilePictureView.setProfileId(items.get(position).getUserID());
        profilePictureView.setPresetSize(ProfilePictureView.SMALL);

        TextView nameView = (TextView) convertView.findViewById(R.id.ranking_name);
        String name = items.get(position).getName();
        nameView.setText(name);

        TextView rankingView = (TextView) convertView.findViewById(R.id.ranking_number);
        String rank = Integer.toString(items.get(position).getAbsoluteXp());
        rankingView.setText(rank + " XP");

        return convertView;
    }

    public void add(Person person) {
        items.add(person);
        notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        List<Person> itemsCopy = new ArrayList<>(items);
        items.clear();
        items = new ArrayList<>(itemsCopy);

        super.notifyDataSetChanged();
    }

    public Person getItem(int pos) {
        return items.get(pos);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public int getCount() {
        return items.size();
    }
}
