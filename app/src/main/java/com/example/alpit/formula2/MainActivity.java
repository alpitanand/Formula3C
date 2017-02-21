package com.example.alpit.formula2;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle aToggle;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        aToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.navig,R.string.open,R.string.Close);
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        mDrawerLayout.addDrawerListener(aToggle);
        toolbar=(Toolbar)findViewById(R.id.nav_action);
        toolbar.setNavigationIcon(R.drawable.navig);
        setSupportActionBar(toolbar);
        aToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setItemIconTintList(null);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerAdapter=new RecyclerAdapter(getApplicationContext());
        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(aToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);

    }}