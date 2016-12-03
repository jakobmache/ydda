package de.mobilityhacks.ydda.youdontdrivealone.utils;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

//Source: http://stackoverflow.com/questions/23464707/display-fb-profile-pic-in-circular-image-view-in-application

public class FacebookUtils {

    public static final String TAG = FacebookUtils.class.getName();

    public void setFacebookProfilePicture(String userID, ProfilePictureView view) throws IOException{
        view.setProfileId(userID);
        view.setPresetSize(ProfilePictureView.CUSTOM);
        //AsyncTask<Void, Void, Bitmap> task = new LoadUserImageTask(view, userID);
        //task.execute();
    }

    private class LoadUserImageTask extends AsyncTask<Void, Void, Bitmap> {

        private ProfilePictureView pictureView;
        private String userId;
        private Exception e;

        public LoadUserImageTask(ProfilePictureView profilePictureView, String userId) {
            pictureView = profilePictureView;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL imageURL = new URL("https://graph.facebook.com/" + params[0] + "/picture?type=large");
                Bitmap bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
                Log.d(TAG, "Bitmap was downloaded from " + imageURL.toString());
                return bitmap;
            }
            catch (Exception e) {
                Log.e(TAG, e.toString());
                this.e = e;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null)
                return;
        }

    }


}
