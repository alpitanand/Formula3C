package com.example.alpit.formula2;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

public class Gravitation extends AppCompatActivity {

    private DrawerLayout gdrawerLayout;
    private NavigationView gnavigationView;
    private ActionBarDrawerToggle gravity_law_toggel;
    private Toolbar gtoolbar;
    private WebView gwebView;

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


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(gravity_law_toggel.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
