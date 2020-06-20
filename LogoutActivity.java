package com.example.dasse;

/*************************************************
 * 프로그램명 : LogoutActiity.java
 * 작성자 : 2016039076 김종우
 * 작성일 : 2020.06.16
 * 프로그램설명 : logout 연결 acticity
 *************************************************/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logoutButton = findViewById(R.id.nav_logout);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });
    }
}
