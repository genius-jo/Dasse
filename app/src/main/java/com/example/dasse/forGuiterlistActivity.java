package com.example.dasse;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
/*************************************************
 * 프로그램명 : forGuiterlistActivity()
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.06.03
 * 프로그램설명 : 기타 가게들의 쿠폰정보를 출력하는 forGuiterlistActivity
 *************************************************/

/*********************************************  2016039066 조광식  ***********************************************/
public class forGuiterlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar a=getSupportActionBar();
        a.hide();
        setContentView(R.layout.activity_for_guitarlist);

    }

}
/*********************************************  2016039066 조광식  ***********************************************/