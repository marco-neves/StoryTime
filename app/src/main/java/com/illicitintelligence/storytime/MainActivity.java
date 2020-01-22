package com.illicitintelligence.storytime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    RVAdapter RVAdapter;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpNavigationView();
        setUpDrawer();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        String[] titles = getResources().getStringArray(R.array.stories_title);
        String[] contents = getResources().getStringArray(R.array.story_content);

        recyclerView = findViewById(R.id.storiesListsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RVAdapter = new RVAdapter(this,titles,contents); // RVAdapter takes two string array
        recyclerView.setAdapter(RVAdapter);                     // hardcoded into my /res.
    }

    private void setUpToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setUpNavigationView() {
        navigationView = findViewById(R.id.navi_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setUpDrawer() {
        drawer = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.home){
            Toast.makeText(this, "Hire Me:)", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
