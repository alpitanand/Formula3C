package com.example.alpit.formula2;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


class Change extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActionBarDrawerToggle toggle3;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        Toolbar toolbar = (Toolbar) findViewById(R.id.change);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.activity_change);
        toggle3 = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.Close);
        drawerLayout.addDrawerListener(toggle3);
        toggle3.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_change);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        setTitle("Conversion");
        viewPager = (ViewPager) findViewById(R.id.change_viewpager);
        setUpViewpager(viewPager);
        TabLayout tabs = (TabLayout) findViewById(R.id.change_tab);
        tabs.setupWithViewPager(viewPager);


    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (toggle3.onOptionsItemSelected(menuItem)) {
            return true;
        }
        return onOptionsItemSelected(menuItem);
    }

    private void setUpViewpager(ViewPager upViewpager) {
        Adapter_tab adapter = new Adapter_tab(getSupportFragmentManager());
        adapter.addFragment(new Distance(), "Distance");
        adapter.addFragment(new Mass(), "Mass");
        upViewpager.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

    static class Adapter_tab extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter_tab(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentTitleList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }
}


