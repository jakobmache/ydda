package de.mobilityhacks.ydda.youdontdrivealone.car;

import android.app.DownloadManager;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.JsonReader;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class OTPAdapter
{
    private static final String IP = "192.168.189.99:9080/";

    public static final String TAG = OTPAdapter.class.getName();

    private boolean debug = true;

    public byte getFuelLevel() {
        byte fuelLevel = 0;
        try {
            URL url = new URL(IP + "vehicle?fields=level_fuel");
        }
        catch(MalformedURLException exc) {
            Log.e(TAG, exc.toString());
        }
        return 120;
    }

    public short getRpm(Context context) throws IOException {
//        try {
//            URL url = new URL("http://" + IP + "vehicle?fields=rpm");
//            Log.d(TAG, "Try to get data on url " + url.toString());
//            Log.d(TAG, "Try to connect to URL " + url.toString());
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Connection", "close");
//            conn.setConnectTimeout(1000);
//            InputStream in = new BufferedInputStream(conn.getInputStream());
//            String text = convertStreamToString(in);
//            Log.d(TAG, " Response: " + text);
//
//            OkHttpClient client = new OkHttpClient();
//            Request request = new Request.Builder()
//                    .url(url)
//                    .addHeader("Connection", "close")
//                    .addHeader("Accept", "text/plain")
//                    .build();
//
//            Response response = client.newCall(request).execute();
//            Log.d(TAG, response.body().toString());

//            RequestQueue queue = Volley.newRequestQueue(context);
//
//            JsonObjectRequest request = new JsonObjectRequest
//                    (Request.Method.GET, url.toString()q, null, new Response.Listener<JSONObject>() {
//
//                        @Override
//                        public void onResponse(JSONObject response) {
//                            Log.d(TAG, response.toString());
//                        }
//                    }, new Response.ErrorListener() {
//
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.e(TAG, error.toString());
//                        }
//                    });
//
//            queue.add(request);
//
//        } catch (Exception e) {
//            Log.e(TAG, e.toString());
//        }



        return 1000;
    }


    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
