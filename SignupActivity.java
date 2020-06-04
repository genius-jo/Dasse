/*************************************************
 * 프로그램명 : LoginActivity.java
 * 작성자 : 2016039077 전현성
 * 작성일 : 2020.05.20
 * 프로그램설명 : 회원가입을 위한 xml과 연결하는 java 파일
 *************************************************/

/*********************************************  2016039077 전현성  ***********************************************/
package com.example.dasse;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.dasse.R;


import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {

    EditText name;
    EditText phone;
    EditText email;
    EditText pw;
    EditText pwcheck;

    DatabaseReference dataBase;
    FirebaseAuth firebaseAuth;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // xml과 연동
        name=findViewById(R.id.activity_signup_edittext_name);
        phone=findViewById(R.id.activity_signup_edittext_phone);
        email=findViewById(R.id.activity_signup_edittext_email);
        pw=findViewById(R.id.activity_signup_edittext_pw);
        pwcheck=findViewById(R.id.activity_signup_edittext_pw_check);


        firebaseAuth = FirebaseAuth.getInstance();



        //회원가입을 눌렀을 시
        Button signUp = findViewById(R.id.activity_signup_button_signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 비밀번호와 비밀번호 확인의 string 선언 (비교용)
                String pw1 = pw.getText().toString();
                String pw2 = pwcheck.getText().toString();

                // 회원가입 양식을 빼먹었을 경우 회원가입 안됨, 실패시 안되는 이유 설명 추가
                if (name.getText().toString().contentEquals("") || phone.getText().toString().contentEquals("")
                        || email.getText().toString().contentEquals("") || pw.getText().toString().contentEquals("") ||
                        pwcheck.getText().toString().contentEquals("")) {
                    Toast.makeText(getApplicationContext(), "양식을 모두 채워주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                //비밀번호가 다르다면
                else if (!(pw.getText().toString().equals(pwcheck.getText().toString()))) {
                    Toast.makeText(getApplicationContext(), "비밀번호가 서로 다릅니다", Toast.LENGTH_SHORT).show();
                    return;
                }

                //비밀번호가 6글자 이상이 아닐 경우
                else if (!(pw.getText().length() > 5)){
                    Toast.makeText(getApplicationContext(), "비밀번호를 6글자 이상 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String sEmail = email.getText().toString();
                String sPw = pw.getText().toString();

                // 서버에 email과 password 등록
                firebaseAuth.createUserWithEmailAndPassword(sEmail, sPw)
                        .addOnCompleteListener(SignupActivity.this,new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){

                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    String fEmail = email.getText().toString();
                                    String uid = user.getUid();
                                    String fName = name.getText().toString();
                                    String fPhone = phone.getText().toString();
                                    String fPw = pw.getText().toString();

                                    HashMap<Object,String> hashMap = new HashMap<>();
                                    // hashmap을 이용해 회원정보 DB에 저장
                                    hashMap.put("uid",uid);
                                    hashMap.put("email",fEmail);
                                    hashMap.put("name",fName);
                                    hashMap.put("phone",fPhone);
                                    hashMap.put("pw",fPw);

                                    // DB에 고객 데이터 저장
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference reference = database.getReference();
                                    reference.child("Users").child(uid).setValue(hashMap);

                                    Toast.makeText(SignupActivity.this, "회원가입 성공!", Toast.LENGTH_SHORT).show();
                                    finish();


                                }
                                else{

                                    Toast.makeText(SignupActivity.this, "회원가입 오류", Toast.LENGTH_SHORT).show();

                                }

                            }

                        });
            }

        });
    }

}
/*********************************************  2016039077 전현성  ***********************************************/
