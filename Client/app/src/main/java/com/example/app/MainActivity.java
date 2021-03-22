package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;

import com.example.app.api.stubs.StubsInitializer;
import com.example.app.api.user.Models.User;
import com.example.app.logic.common.GlobalState;
import com.example.app.logic.user.RolesConstants;
import com.example.app.logic.user.UserContext;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        InitIfNotInitialized();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!checkIsAuthorized()){
            redirectToLogin();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_create_user, R.id.nav_user_profile, R.id.nav_schedule)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void InitIfNotInitialized() {
        if (!GlobalState.isInitialized()) {
            StubsInitializer.init();
            GlobalState.setInitialized(true);
        }
    }

    private boolean checkIsAuthorized() {
        return UserContext.getInstance().isAuthorized();
    }

    private void redirectToLogin() {
        Intent functionTab = new Intent(
                this.getApplicationContext(),
                AuthActivity.class);

        startActivity(functionTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}