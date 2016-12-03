package de.mobilityhacks.ydda.youdontdrivealone;
/**
 * Created with the help of the following github repository:
 * https://github.com/sitepoint-editors/Android-Facebook-API
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class FacebookLogin extends AppCompatActivity {

    public static final String TAG = FacebookLogin.class.getName();

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        AppEventsLogger.activateApp(this);

        setContentView(R.layout.facebooklogin);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "Successfully logged in!");
                nextActivity(Profile.getCurrentProfile());
            }

            @Override
            public void onCancel() {
                Log.e(TAG, "Login cancelled");
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, error.getMessage());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isLoggedIn()) {
            nextActivity(Profile.getCurrentProfile());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public boolean isLoggedIn() {
        return AccessToken.getCurrentAccessToken() != null &&
                !AccessToken.getCurrentAccessToken().isExpired();
    }

    private void nextActivity(Profile profile){
        Log.d(TAG, "Start next activity!");
        if(profile != null){
            Intent main = new Intent(this, MainActivity.class);
            main.putExtra("name", profile.getFirstName());
            main.putExtra("surname", profile.getLastName());
            main.putExtra("userId", profile.getId());
            startActivity(main);
            Log.d(TAG, "Started new activity!");
        }
    }

}
