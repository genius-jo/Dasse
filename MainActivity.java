package com.example.dasse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

/*************************************************
 * 프로그램명 : MainActivity.java
 * 작성자 : 2016039076김종우
 * 작성일 : 2020.05.30
 * 프로그램설명 : drawlayout과 로그아웃을 연결할 java 파일
 *************************************************/

public class MainActivity extends AppCompatActivity {
    Fragment replace_food;
    Fragment replace_cate;
    Button nav_logout;
    private FirebaseAuth mAuth;
    private DrawerLayout drawerLayout;
    private View drawerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
/************************** 2016039076 김종우 *********************************************/
        mAuth = FirebaseAuth.getInstance();
        nav_logout = (Button)findViewById(R.id.nav_logout);

        nav_logout.setOnClickListener((View.OnClickListener) this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawerView);
        drawerLayout.setDrawerListener(listener);

        /************************** 2016039076 김종우 *********************************************/
        replace_cate = new CategoriFragment();
        replace_food = new FoodlistFragment();
    }

    /************************** 2016039076 김종우 *********************************************/
    private void signOut(){
        FirebaseAuth.getInstance().signOut();
    }
    public void onClick(View v){

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
    /************************** 2016039076 김종우 *********************************************/
    // onFragmentChanged 구현자 : 신한솔
   public void onFragmentChanged(int index){
        if(index==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout, replace_cate).commit();
        }else if(index==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.drawer_layout, replace_food).commit();
        }
    }
}
