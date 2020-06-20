

package com.example.dasse;
/*************************************************
 * 프로그램명 : FoodinfoBarcodeActivity.java
 * 작성자 : 2016039077 전현성
 * 작성일 : 2020.06.06
 * 프로그램설명 : 저장후 내 쿠폰 클릭 시 바코드가 존재하는 페이지의 파일
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class FoodinfoBarcodeActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActionBar a=getSupportActionBar();
        a.hide();
        setContentView(R.layout.activity_foodinfobarcode);
        // 상품 정보에 해당하는 xml 호출
        ImageView foodImage = (ImageView) findViewById(R.id.activity_foodinfobarcode_imageview_food);
        final TextView storeName = (TextView) findViewById(R.id.activity_foodinfobarcode_textview_store_name);
        final TextView menuName = (TextView) findViewById(R.id.activity_foodinfobarcode_textview_store_menu_name);
        final TextView oldPrice = (TextView) findViewById(R.id.activity_foodinfobarcode_textview_menu_old_price);
        final TextView discountPrice = (TextView) findViewById(R.id.activity_foodinfobarcode_textview_menu_discount_price);
        final TextView foodInfo = (TextView) findViewById(R.id.activity_foodinfobarcode_textview_info);
        final TextView storeLocation = (TextView) findViewById(R.id.activity_foodinfobarcode_textview_store_location);
        Button useCoupon = (Button) findViewById(R.id.activity_foodinfobarcode_button_use_coupon);


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

        //각 정보들을 셋팅
        foodImage.setImageResource(sFoodImage);
        storeName.setText(sStoreName);
        menuName.setText(sMenuName);
        oldPrice.setText(sOldPrice);
        discountPrice.setText(sDiscountPrice);
        foodInfo.setText(sFoodInfo);
        storeLocation.setText(sStoreLocation);


        //쿠폰 사용 버튼을 클릭하면
        useCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ImgID를 uid로 가지는 데이터를 firebase에 생성

                String sImgID = Integer.toString(sFoodImage);

                //이용시간을 저장하기 위한 함수
                long now = System.currentTimeMillis();
                Date mDate = new Date(now);
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd k:mm:ss");
                String sUsedTime = simpleDate.format(mDate);

                HashMap<Object,String> hashMap = new HashMap<>();
                // hashmap을 이용해 쿠폰정보 DB에 저장
                hashMap.put("storeName",sStoreName);
                hashMap.put("menuName",sMenuName);
                hashMap.put("oldPrice",sOldPrice);
                hashMap.put("discountPrice",sDiscountPrice);
                hashMap.put("foodInfo",sFoodInfo);
                hashMap.put("storeLocation",sStoreLocation);
                hashMap.put("imgId", sImgID);
                hashMap.put("usedTime", sUsedTime);

                //사용내역에 방금 사용한 쿠폰 데이터 저장
                databaseReference.child("Users").child(myUid).child("UsedCoupon").child(sImgID).setValue(hashMap);
                Toast.makeText(getApplicationContext(),"쿠폰 사용 완료!" , Toast.LENGTH_SHORT).show();

                //내 쿠폰 리스트에서 사용된 쿠폰 삭제
                databaseReference.child("Users").child(myUid).child("HaveCoupon").child(sImgID).removeValue();

            }
        });

    }
}

/*********************************************  2016039077 전현성  ***********************************************/
