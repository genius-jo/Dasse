package com.example.dasse;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dasse.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
    /*************************************************
     * 프로그램명 : LoginActivity.java
     * 작성자 : 2016039077 전현성
     * 작성일 : 2020.05.20
     * 프로그램설명 : 로그인을 위한 xml과 연결하는 java 파일
     *************************************************/

/*********************************************  2016039077 전현성  ***********************************************/
public class LoginActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        // xml 연결
        final EditText email = findViewById(R.id.activity_login_edittext_email);
        final EditText pw = findViewById(R.id.activity_login_edittext_pw);
        final Button loginButton = findViewById(R.id.activity_login_button_login);
        Button SignupButton = findViewById(R.id.activity_login_button_signup);


        // 회원가입 버튼을 눌렀을 때
        SignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent를 이용해서 Activity 호출
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        
/*********************************************  2016039077 전현성 ***********************************************/
        // firebase 객체 선언
        firebaseAuth = firebaseAuth.getInstance();
        //로그인 버튼을 눌렀을 때
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_log = email.getText().toString().trim();
                String pw_log = pw.getText().toString().trim();
                if (email.getText().toString().contentEquals(""))
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                else if (pw.getText().toString().contentEquals(""))
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                    //아이디와 비밀번호가 입력되었다면,
                    // 1. 자동 로그인 체크 아이디 기억 체크
                    // 2. 그후 인터넷 연결



                else {
                    firebaseAuth.signInWithEmailAndPassword(email_log, pw_log)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        Toast.makeText(LoginActivity.this,"로그인 성공", Toast.LENGTH_SHORT).show();
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(LoginActivity.this,"로그인 오류", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }

            }
        });


    }
}
