package com.example.dasse;

/*************************************************
 * 프로그램명 : SubActivity.java
 * 작성자 : 2016039076 김종우
 * 작성일 : 2020.06.13
 * 프로그램설명 : logout 버튼 누른후 화면이동 java
 *************************************************/

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
// 로그아웃 버튼 누른 후 화면 이동
public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }
}
