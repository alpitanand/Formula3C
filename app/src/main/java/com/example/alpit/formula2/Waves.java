package com.example.alpit.formula2;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

public class Waves extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle phy_law_toggel;
    private Toolbar toolbar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waves);
        Toolbar toolbar = (Toolbar) findViewById(R.id.phy_lawtoolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.Kinematics);
        drawerLayout = (DrawerLayout) findViewById(R.id.phy_draw);
        navigationView = (NavigationView) findViewById(R.id.nav_view_phy);
        phy_law_toggel = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.Close);
        drawerLayout.addDrawerListener(phy_law_toggel);
        toolbar = (Toolbar) findViewById(R.id.phy_lawtoolbar);
        setSupportActionBar(toolbar);
        phy_law_toggel.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
        webView = (WebView) findViewById(R.id.phy_law_web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/mathscribe/Waves.html");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(phy_law_toggel.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}