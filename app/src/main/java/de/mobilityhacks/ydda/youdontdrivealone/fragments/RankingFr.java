package de.mobilityhacks.ydda.youdontdrivealone.fragments;

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

import de.mobilityhacks.ydda.youdontdrivealone.R;


public class RankingFr extends ListFragment {

    public static final String TAG = RankingFr.class.getName();

    private JSONObject friends;
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


        final GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response)
                    {
                        try {
                            friends = new JSONObject(String.valueOf(response.getJSONObject()));

                            Log.d(TAG, friends.toString());

                            JSONObject graph = friends.getJSONObject("friends");
                            JSONArray data = graph.getJSONArray("data");

                            for (int i = 0; i < data.length(); i++) {
                                if (data.get(i) != null) {
                                    JSONObject friend = data.getJSONObject(i);
                                    adapter.add(friend.get("id").toString(),
                                            friend.get("name").toString());
                                }
                            }


                        } catch (Exception e) {
                            Log.e(TAG, e.getMessage());
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "friends");
        request.setParameters(parameters);
        Log.d(TAG, request.toString());
        request.executeAsync();

        ((RankingListAdapter) getListAdapter()).notifyDataSetChanged();

    }
}
