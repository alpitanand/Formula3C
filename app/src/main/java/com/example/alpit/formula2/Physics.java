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

public class Physics extends AppCompatActivity {
private DrawerLayout mpDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle aToggle;
    private RecyclerView recyclerView;
    private Physics_recycler physics_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);
        mpDrawerLayout = (DrawerLayout) findViewById(R.id.drawer1);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        aToggle = new ActionBarDrawerToggle(this, mpDrawerLayout, R.string.open, R.string.Close);
        mpDrawerLayout.addDrawerListener(aToggle);
        toolbar = (Toolbar) findViewById(R.id.nav_action1);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        physics_recycler = new Physics_recycler(getApplicationContext());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(physics_recycler);
        aToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if(aToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
