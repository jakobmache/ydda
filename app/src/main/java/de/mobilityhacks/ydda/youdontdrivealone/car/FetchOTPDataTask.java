package de.mobilityhacks.ydda.youdontdrivealone.car;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class FetchOTPDataTask extends AsyncTask<OTPAdapter, Void, Short>{

    private Exception exception;
    private Context context;

    public static final String TAG = FetchOTPDataTask.class.getName();

    public FetchOTPDataTask(Context context) {
        this.context = context;
    }

    protected Short doInBackground(OTPAdapter... adapter) {
        try {
            OTPAdapter usedAdapter = adapter[0];
            return usedAdapter.getRpm(context);
        }
        catch (Exception e) {
            exception = e;
            e.printStackTrace();

            Log.e(TAG, e.getMessage());
            return null;
        }
    }


    public Exception getException() {
        return exception;
    }
}
