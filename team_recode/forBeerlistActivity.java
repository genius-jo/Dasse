package com.example.dasse;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

/*************************************************
 * 프로그램명 : forBeerlistActivity()
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.06.03
 * 프로그램설명 : 술집의 쿠폰정보들을 출력하는 forBeerlistActivity
 *************************************************/

/*********************************************  2016039066 조광식  ***********************************************/

public class forBeerlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar a=getSupportActionBar();
        a.hide();
        setContentView(R.layout.activity_for_beerlist);

    }

}
/*********************************************  2016039066 조광식  ***********************************************/