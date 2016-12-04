package de.mobilityhacks.ydda.youdontdrivealone;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.Profile;

import java.util.List;
import java.util.Random;

import de.mobilityhacks.ydda.youdontdrivealone.backend.persons.Person;
import de.mobilityhacks.ydda.youdontdrivealone.fragments.QuestsFr;
import de.mobilityhacks.ydda.youdontdrivealone.fragments.RankingFr;
import de.mobilityhacks.ydda.youdontdrivealone.utils.ProfilePictureView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;

    public static final String TAG = MainActivity.class.getName();

    private List<Person> persons;

    private Person you;

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

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(0);

        //Now load facebook data

        if (getIntent().getStringExtra("name") != null
                && getIntent().getStringExtra("surname") != null) {
            TextView userNameText = (TextView) navigationView.getHeaderView(0).
                    findViewById(R.id.username);
            userNameText.setText(getIntent().getStringExtra("name").toString() + " " +
                    getIntent().getStringExtra("surname").toString());
            you = new Person(getIntent().getStringExtra("name")+ " " + getIntent().getStringExtra("surname"), "");
            you.setAbsoluteXp(new Random().nextInt(120));
        }

        if (getIntent().getStringExtra("userId") != null) {
            ProfilePictureView imageView = (ProfilePictureView) navigationView.getHeaderView(0).
                    findViewById(R.id.user_image_view);
            imageView.setProfileId(getIntent().getStringExtra("userId"));
            imageView.setPresetSize(ProfilePictureView.CUSTOM);
            if (you != null) you.setUserID(getIntent().getStringExtra("userId"));
        }

        if (you != null) {
            TextView xpView = (TextView) navigationView.getHeaderView(0).findViewById(R.id.user_xp);
            xpView.setText(you.getAbsoluteXp() + " XP");
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        ProfilePictureView imageView = (ProfilePictureView) navigationView.getHeaderView(0).
                findViewById(R.id.user_image_view);
        imageView.setProfileId(Profile.getCurrentProfile().getId());
        imageView.setPresetSize(ProfilePictureView.CUSTOM);
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
        transaction.replace(R.id.content_frame, f);
        transaction.addToBackStack(null);
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if (id == R.id.rankingIt) {
            persons = ((RankingFr) f).getPersons();
        }
        return true;
    }

    public Person getYou() {
        return you;
    }

    public List<Person> getPersons() {
        return persons;
    }
}