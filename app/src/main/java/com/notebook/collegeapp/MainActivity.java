package com.notebook.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;
import com.notebook.collegeapp.ebook.EbookActivity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
            startActivity(new Intent(this, EbookActivity.class));
        }
        else if (item.getItemId() == R.id.navigation_video)
        {
            String url = "https://www.youtube.com/@juetguna6527";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Toast.makeText(this, "Video Lectures", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_rate)
        {
            Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_share)
        {
            String url="https://github.com/TheScriptRailoth/College-App";
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plane");
            intent.putExtra(Intent.EXTRA_SUBJECT,"Checkout this application");
            intent.putExtra(Intent.EXTRA_TEXT,"Your Application Link Is Here: \n"+url);
            startActivity(Intent.createChooser(intent,"Share Via"));
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_theme)
        {
            Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.navigation_website)
        {
            String url="https://www.juet.ac.in/";
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
}