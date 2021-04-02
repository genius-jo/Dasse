

package com.example.dasse;
/*************************************************
 * 프로그램명 : FoodinfoUsedActivity.java
 * 작성자 : 2016039077 전현성
 * 작성일 : 2020.06.06
 * 프로그램설명 : 사용된 쿠폰의 정보를 출력하기 위한 파일
 *************************************************/


/*********************************************  2016039077 전현성  ***********************************************/
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FoodinfoUsedActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActionBar a=getSupportActionBar();
        a.hide();
        setContentView(R.layout.activity_foodinfoused);
        // 상품 정보에 해당하는 xml 호출
        ImageView foodImage = (ImageView) findViewById(R.id.activity_foodinfoused_imageview_food);
        final TextView storeName = (TextView) findViewById(R.id.activity_foodinfoused_textview_store_name);
        final TextView menuName = (TextView) findViewById(R.id.activity_foodinfoused_textview_store_menu_name);
        final TextView oldPrice = (TextView) findViewById(R.id.activity_foodinfoused_textview_menu_old_price);
        final TextView discountPrice = (TextView) findViewById(R.id.activity_foodinfoused_textview_menu_discount_price);
        final TextView foodInfo = (TextView) findViewById(R.id.activity_foodinfoused_textview_info);
        final TextView storeLocation = (TextView) findViewById(R.id.activity_foodinfoused_textview_store_location);
        TextView usedTime = (TextView) findViewById((R.id.activity_foodinfoused_textview_usedtime));



        // 쿠폰을 저장하기 위한 준비
        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        final String myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // 전달받은 intent 호출
        final Intent intent = getIntent();


        // 전달받은 정보 xml 연동
        String imgTemp =  intent.getExtras().getString("ImgID");
        final int sFoodImage = Integer.parseInt(imgTemp);
        final String sStoreName = intent.getExtras().getString("StoreName");
        final String sMenuName = intent.getExtras().getString("MenuName");
        final String sOldPrice = intent.getExtras().getString("OldPrice");
        final String sDiscountPrice = intent.getExtras().getString("DiscountPrice");
        final String sFoodInfo = intent.getExtras().getString("FoodInfo");
        final String sStoreLocation = intent.getExtras().getString("StoreLocation");
        String sUsedTime = intent.getExtras().getString("UsedTime");

        //각 정보들을 셋팅
        foodImage.setImageResource(sFoodImage);
        storeName.setText(sStoreName);
        menuName.setText(sMenuName);
        oldPrice.setText(sOldPrice);
        discountPrice.setText(sDiscountPrice);
        foodInfo.setText(sFoodInfo);
        storeLocation.setText(sStoreLocation);
        usedTime.setText(sUsedTime);


    }
}

/*********************************************  2016039077 전현성  ***********************************************/
