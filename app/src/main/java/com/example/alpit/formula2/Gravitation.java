package com.example.alpit.formula2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Gravitation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    private DrawerLayout gdrawerLayout;
    private NavigationView gnavigationView;
    private ActionBarDrawerToggle gravity_law_toggel;
    private Toolbar gtoolbar;
    private WebView gwebView;
    private DataBaseHandler db;
    private CheckBox checkBox;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravitation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.gravity_lawtoolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.Gravitation);
        gdrawerLayout = (DrawerLayout) findViewById(R.id.gravity_draw);
       gnavigationView = (NavigationView) findViewById(R.id.nav_view_gravity);
        gravity_law_toggel = new ActionBarDrawerToggle(this, gdrawerLayout, R.string.open, R.string.Close);
        gdrawerLayout.addDrawerListener(gravity_law_toggel);
        gtoolbar = (Toolbar) findViewById(R.id.gravity_lawtoolbar);
        setSupportActionBar(toolbar);
        gravity_law_toggel.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gnavigationView.setItemIconTintList(null);
        gwebView = (WebView) findViewById(R.id.gravity_law_web);
        gwebView.getSettings().setJavaScriptEnabled(true);
        gwebView.getSettings().setBuiltInZoomControls(true);
        gwebView.loadUrl("file:///android_asset/mathscribe/gravitation.html");
        db = new DataBaseHandler(this);
        checkBox = (CheckBox) findViewById(R.id.fav);
        checkBox.setChecked(getAsp("checkbox1"));
        checkBox.setOnCheckedChangeListener(this);
        gnavigationView.setNavigationItemSelectedListener(this);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gwebView.scrollTo(0, 0);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(gravity_law_toggel.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.favourite) {
            startActivity(new Intent(getApplicationContext(), FavoritePage.class));
        }
        gdrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean check1) {
        if (checkBox.isChecked()) {

            saveInSp("checkbox1", check1);
            db.add_activity(this.getClass().getSimpleName());
        } else if (!checkBox.isChecked()) {

            saveInSp("checkbox1", check1);
            db.del_activity(this.getClass().getSimpleName());

        }

    }

    private boolean getAsp(String key) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("ALpit", android.content.Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    private void saveInSp(String key, boolean value) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("ALpit", android.content.Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}
