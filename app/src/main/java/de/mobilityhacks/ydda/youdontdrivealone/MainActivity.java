package de.mobilityhacks.ydda.youdontdrivealone;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import de.mobilityhacks.ydda.youdontdrivealone.fragments.FriendsFr;
import de.mobilityhacks.ydda.youdontdrivealone.fragments.QuestsFr;
import de.mobilityhacks.ydda.youdontdrivealone.fragments.RankingFr;
import de.mobilityhacks.ydda.youdontdrivealone.social.Quest;
import de.mobilityhacks.ydda.youdontdrivealone.social.QuestCreate;
import de.mobilityhacks.ydda.youdontdrivealone.utils.FacebookUtils;
import de.mobilityhacks.ydda.youdontdrivealone.utils.ProfilePictureView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = MainActivity.class.getName();
    public String questAvgName = getString(R.string.questAvg);
    public String questKmsName = getString(R.string.questKms);
    public String questPercentageName = getString(R.string.questPercentage);

    public String questAvgDesc = getString(R.string.questAvgDesc);
    public String questKmsDesc = getString(R.string.questKmsDesc);
    public String questPercentageDesc = getString(R.string.questPercentageDesc);
    public QuestCreate questCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        questCreate = new QuestCreate(this);

        //Now load facebook data

        if (getIntent().getStringExtra("name") != null
                && getIntent().getStringExtra("surname") != null) {
            TextView userNameText = (TextView) navigationView.getHeaderView(0).
                    findViewById(R.id.username);
            userNameText.setText(getIntent().getStringExtra("name").toString() + " " +
                    getIntent().getStringExtra("surname").toString());
        }

        if (getIntent().getStringExtra("userId") != null) {
            ProfilePictureView imageView = (ProfilePictureView) navigationView.getHeaderView(0).
                    findViewById(R.id.user_image_view);
            try {
                new FacebookUtils().setFacebookProfilePicture(
                        getIntent().getStringExtra("userId"), imageView);
            }
            catch (IOException e) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        getString(R.string.load_user_failed), Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment f = null;

        if (id == R.id.rankingIt) {
            f = new RankingFr();
        } else if (id == R.id.questsIt) {
            f = new QuestsFr();
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_main, f);
        transaction.addToBackStack(null);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public QuestCreate getQuestCreate() {
        return questCreate;
    }
    /*public Quest create() {
        return QuestCreate.createQuest(this);
    }*/
    /*public String getQuestAvgName() {
        return questAvgName;
    }
    public String getQuestKmsName() {
        return questKmsName;
    }
    public String getPercentageName() {
        return questPercentageName;
    }
    public String getQuestAvgDesc() {
        return questAvgDesc;
    }
    public String getQuestKmsDesc() {
        return questKmsDesc;
    }
    public String getPercentageDesc() {
        return questPercentageDesc;
    }*/
}