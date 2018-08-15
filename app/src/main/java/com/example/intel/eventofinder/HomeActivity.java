package com.example.intel.eventofinder;

import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.SearchView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,
myeventsFragment.OnFragmentInteractionListener , AlertsFragment.OnFragmentInteractionListener , ProfFragment.OnFragmentInteractionListener
{

    private static final String TAG ="HomeActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        NavigationView navigationView = findViewById(R.id.nav_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        initSearch();
    }
    private void initSearch() {
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = findViewById(R.id.search_bar);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(getApplicationContext(), HomeActivity.class)));
        searchView.setIconifiedByDefault(false);
        searchView.setSubmitButtonEnabled(true);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        switch(item.getItemId()) {
            case R.id.sign_out:
                //signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.Home:
                Fragment fragment = new homeFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.Main_content,fragment)
                        .commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.Alerts:
                Log.e(TAG,"Alerts");
                Fragment fragment1 = new AlertsFragment();
                FragmentManager fragmentManager1 = getFragmentManager();
                fragmentManager1.beginTransaction()
                        .replace(R.id.Main_content,fragment1)
                        .commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.MyEvents:
                Fragment fragment2 = new myeventsFragment();
                FragmentManager fragmentManager2 = getFragmentManager();
                fragmentManager2.beginTransaction()
                        .replace(R.id.Main_content,fragment2)
                        .commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.Profile:
                Fragment fragment3 = new ProfFragment();
                FragmentManager fragmentManager3 = getFragmentManager();
                fragmentManager3.beginTransaction()
                        .replace(R.id.Main_content,fragment3)
                        .commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

}
