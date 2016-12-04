package de.mobilityhacks.ydda.youdontdrivealone.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import de.mobilityhacks.ydda.youdontdrivealone.R;
import de.mobilityhacks.ydda.youdontdrivealone.backend.persons.Person;


public class RankingFr extends ListFragment {

    public static final String TAG = RankingFr.class.getName();

    private JSONObject friends;

    private List<Person> persons = new ArrayList<>();
    private RankingListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        adapter = new RankingListAdapter(getContext());
        setListAdapter(adapter);

        searchFriends();

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


    }


    private void searchFriends() {
        if (getListAdapter() == null) {
            RankingListAdapter adapter = new RankingListAdapter(getContext());
        }

        final RankingListAdapter adapter = (RankingListAdapter) getListAdapter();
        final Random random = new Random();

        final Bundle params = new Bundle();
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "me/friends",
                params,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        try {
                            friends = new JSONObject(String.valueOf(response.getJSONObject()));

                            Log.d(TAG, params.toString());
                            Log.d(TAG, "Friends request: " + friends.toString());

                            if (!friends.isNull("data")) {
                                JSONArray data = friends.getJSONArray("data");

                                Log.d(TAG, "Data length: " + data.length());

                                for (int i = 0; i < data.length(); i++) {
                                    if (data.get(i) != null) {
                                        JSONObject friend = data.getJSONObject(i);
                                        Person person = new Person(friend.get("name").toString(),
                                                friend.get("id").toString());
                                        person.setAbsoluteXp(random.nextInt(100));
                                        persons.add(person);
                                    }
                                }
                            }

                            Collections.sort(persons, new Comparator<Person>() {
                                @Override
                                public int compare(Person person, Person t1) {
                                    return person.getAbsoluteXp() < t1.getAbsoluteXp() ? 1 : -1;
                                }
                            });

                            for (Person person:persons) {
                                adapter.add(person);
                            }
                        } catch (Exception e) {
                            Log.e(TAG, e.getMessage());

                        }
                        ;


                        Log.d(TAG, "Finished task: " + persons.toString());

                        ((RankingListAdapter) getListAdapter()).notifyDataSetChanged();


                    }
                }).executeAsync();
    }
}


