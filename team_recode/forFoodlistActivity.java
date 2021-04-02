package com.example.dasse;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
/*************************************************
 * 프로그램명 : forFoodlistActivity()
 * 작성자 : 2016039084 신한솔
 * 작성일 : 2020.06.05
 * 프로그램설명 : 음식점들의 쿠폰정보를 출력하는 forFoodlistActivity
 *************************************************/

/*********************************************  2016039084 신한솔  ***********************************************/
public class forFoodlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar a=getSupportActionBar();
        a.hide();
        setContentView(R.layout.activity_for_foodlist);

    }

}
/*********************************************  2016039084 신한솔  ***********************************************/