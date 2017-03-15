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
import android.widget.RelativeLayout;


public class Kinematics extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener {
    public DataBaseHandler db;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle phy_law_toggel;
    private Toolbar toolbar;
    private WebView webView;
    private FloatingActionButton floatingActionButton;
    private RelativeLayout relativeLayout;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinematics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.phy_lawtoolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.Kinematics);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        drawerLayout = (DrawerLayout) findViewById(R.id.phy_draw);
        navigationView = (NavigationView) findViewById(R.id.nav_view_phy);
        phy_law_toggel = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.Close);
        drawerLayout.addDrawerListener(phy_law_toggel);
        toolbar = (Toolbar) findViewById(R.id.phy_lawtoolbar);
        setSupportActionBar(toolbar);
        phy_law_toggel.syncState();
        checkBox = (CheckBox) findViewById(R.id.fav);
        checkBox.setChecked(getAsp("checkbox"));
        checkBox.setOnCheckedChangeListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
        webView = (WebView) findViewById(R.id.phy_law_web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.loadUrl("file:///android_asset/mathscribe/Kinematics.html");
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.scrollTo(0, 0);
            }
        });
        navigationView.setNavigationItemSelectedListener(this);
        db = new DataBaseHandler(this);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (phy_law_toggel.onOptionsItemSelected(item)) {
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
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onCheckedChanged(CompoundButton buttonView, boolean check1) {
        if (checkBox.isChecked()) {

            saveInSp("checkbox", check1);
            db.add_activity(this.getClass().getSimpleName());
        } else if (!checkBox.isChecked()) {

            saveInSp("checkbox", check1);
            db.del_activity(this.getClass().getSimpleName());

        }

    }

    private boolean getAsp(String key) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("ALpit", android.content.Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }

    private void saveInSp(String key, boolean value) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("ALpit", android.content.Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }


}
