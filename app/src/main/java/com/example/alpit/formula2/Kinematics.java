package com.example.alpit.formula2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;


public class Kinematics extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle phy_law_toggel;
    private Toolbar toolbar;
    private WebView webView;
    private FloatingActionButton floatingActionButton;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinematics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.phy_lawtoolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.Kinematics);
        relativeLayout=(RelativeLayout)findViewById(R.id.relative);
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
        webView.getSettings().setBuiltInZoomControls(false);
        webView.loadUrl("file:///android_asset/mathscribe/Kinematics.html");
        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            webView.scrollTo(0,0);
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(phy_law_toggel.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
