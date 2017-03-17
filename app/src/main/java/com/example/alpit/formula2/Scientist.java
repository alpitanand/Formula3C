package com.example.alpit.formula2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Scientist extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientist);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_scientist);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        toolbar = (Toolbar) findViewById(R.id.science_tool);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
        recyclerView = (RecyclerView) findViewById(R.id.science_recycler);
        Science_recycler science_recycler = new Science_recycler(getApplicationContext());
        recyclerView.setAdapter(science_recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
