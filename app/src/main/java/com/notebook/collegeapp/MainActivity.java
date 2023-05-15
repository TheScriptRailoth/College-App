package com.notebook.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this,R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);
        toggle= new ActionBarDrawerToggle(this, drawerLayout,R.string.start, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        navigationView.setNavigationItemSelectedListener(this);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.navigation_developer)
        {
            Toast.makeText(this, "Developers", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_ebook)
        {
            Toast.makeText(this, "Ebooks", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_video)
        {
            Toast.makeText(this, "Video Lectures", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_rate)
        {
            Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_share)
        {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_theme)
        {
            Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_website)
        {
            Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}