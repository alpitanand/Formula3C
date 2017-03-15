package com.example.alpit.formula2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class Unitconversion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActionBarDrawerToggle toggle;
    private DataBaseHandler db;
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private Unit_recycler unit_recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitconversion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.conversion);
        setSupportActionBar(toolbar);
        setTitle("Cheat tools");
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_unit);
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_unitconversion);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        db = new DataBaseHandler(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        unit_recycler = new Unit_recycler(getApplicationContext());
        recyclerView.setAdapter(unit_recycler);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.favourite) {
            startActivity(new Intent(getApplicationContext(), FavoritePage.class));
        } else if (id == R.id.unitconversion) {
            startActivity(new Intent(getApplicationContext(), Unitconversion.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
