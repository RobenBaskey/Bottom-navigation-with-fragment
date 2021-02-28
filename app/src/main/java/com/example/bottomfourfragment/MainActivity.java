package com.example.bottomfourfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.bottomfourfragment.fragments.Account;
import com.example.bottomfourfragment.fragments.Appointment;
import com.example.bottomfourfragment.fragments.Chats;
import com.example.bottomfourfragment.fragments.Home;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameLayout;
    private BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);

        navigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new Home()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.navigation_home:
                fragment = new Home();
                break;
            case R.id.navigation_appointment:
                fragment = new Appointment();
                break;
            case R.id.navigation_chats:
                fragment = new Chats();
                break;
            case R.id.navigation_account:
                fragment = new Account();
                break;
        }

        return loadFrag(fragment);
    }

    private boolean loadFrag(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , fragment).commit();
            return true;
        }
        return false;
    }
}