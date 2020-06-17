package com.example.dasse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {
    Fragment replace_food;
    Fragment replace_cate;
    private DrawerLayout drawerLayout;
    private View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //신한솔 -> 액션바 없애기
        ActionBar a=getSupportActionBar();
        a.hide();

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavController navController2 = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController2);
        NavController navController3 = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController3);

        Button logoutBtn = findViewById(R.id.nav_logout);
        logoutBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawerView);
        drawerLayout.setDrawerListener(listener);
        replace_cate = new CategoriFragment();
        replace_food = new FoodlistFragment();
    }

    DrawerLayout.DrawerListener listener=new DrawerLayout.DrawerListener(){
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }

        @Override
        public void onDrawerStateChanged(int newState) {
        }
    };

    // callother() 구현자 : 신한솔

    public void callother(int x){
        if(x==0){
            Intent intent0 = new Intent(this, forFoodlistActivity.class);
            startActivity(intent0);
        }
        else if(x==1){
            Intent intent0 = new Intent(this, forCafelistActivity.class);
            startActivity(intent0);
        }

        else if(x==2){
            Intent intent0 = new Intent(this, forBeerlistActivity.class);
            startActivity(intent0);
        }

        else if(x==3){
            Intent intent0 = new Intent(this, forPlaylistActivity.class);
            startActivity(intent0);
        }

        else if(x==4){
            Intent intent0 = new Intent(this, forStudylistActivity.class);
            startActivity(intent0);
        }

        else if(x==5){
            Intent intent0 = new Intent(this, forGuiterlistActivity.class);
            startActivity(intent0);
        }

    }
}
