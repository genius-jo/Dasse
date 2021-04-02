

package com.example.dasse;

/*************************************************
 * 프로그램명 : FoodinfoActivity.java
 * 작성자 : 2016039077 전현성
 * 작성일 : 2020.05.28
 * 프로그램설명 : 쿠폰 클릭시 쿠폰에 대한 정보를 위한 java 파일
 *************************************************/


/*********************************************  2016039077 전현성  ***********************************************/

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FoodinfoActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar a=getSupportActionBar();
        a.hide();
        setContentView(R.layout.activity_foodinfo);
        // 상품 정보에 해당하는 xml 호출
        ImageView foodImage = (ImageView) findViewById(R.id.activity_foodinfo_imageview_food);
        final TextView storeName = (TextView) findViewById(R.id.activity_foodinfobarcode_textview_store_name);
        final TextView menuName = (TextView) findViewById(R.id.activity_foodinfo_textview_store_menu_name);
        final TextView oldPrice = (TextView) findViewById(R.id.activity_foodinfo_textview_menu_old_price);
        final TextView discountPrice = (TextView) findViewById(R.id.activity_foodinfo_textview_menu_discount_price);
        final TextView foodInfo = (TextView) findViewById(R.id.activity_foodinfo_textview_info);
        final TextView storeLocation = (TextView) findViewById(R.id.activity_foodinfo_textview_store_location);
        Button getCoupon = (Button) findViewById((R.id.activity_foodinfo_button_getcoupon));

        // 쿠폰을 저장하기 위한 준비
        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();
        final String myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // 전달받은 intent 호출
        final Intent intent = getIntent();

        // 전달받은 정보 xml 연동
        final int sFoodImage = intent.getExtras().getInt("ImgID");
        final String sStoreName = intent.getExtras().getString("StoreName");
        final String sMenuName = intent.getExtras().getString("MenuName");
        final String sOldPrice = intent.getExtras().getString("OldPrice");
        final String sDiscountPrice = intent.getExtras().getString("DiscountPrice");
        final String sFoodInfo = intent.getExtras().getString("FoodInfo");
        final String sStoreLocation = intent.getExtras().getString("StoreLocation");

        //각 정보들을 셋팅
        foodImage.setImageResource(sFoodImage);
        storeName.setText(sStoreName);
        menuName.setText(sMenuName);
        oldPrice.setText(sOldPrice);
        discountPrice.setText(sDiscountPrice);
        foodInfo.setText(sFoodInfo);
        storeLocation.setText(sStoreLocation);

        //쿠폰 다운로드를 클릭하면
        getCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //ImgID를 uid로 가지는 데이터를 firebase에 생성
                String sImgID = Integer.toString(sFoodImage);

                HashMap<Object,String> hashMap = new HashMap<>();
                // hashmap을 이용해 쿠폰정보 DB에 저장
                hashMap.put("storeName",sStoreName);
                hashMap.put("menuName",sMenuName);
                hashMap.put("oldPrice",sOldPrice);
                hashMap.put("discountPrice",sDiscountPrice);
                hashMap.put("foodInfo",sFoodInfo);
                hashMap.put("storeLocation",sStoreLocation);
                hashMap.put("imgId", sImgID);

                // HaveCoupon 경로에 데이터 저장
                databaseReference.child("Users").child(myUid).child("HaveCoupon").child(sImgID).setValue(hashMap);
                Toast.makeText(getApplicationContext(),"쿠폰 저장 완료!" , Toast.LENGTH_SHORT).show();



            }
        });


    }
}

/*********************************************  2016039077 전현성  ***********************************************/
