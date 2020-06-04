
/*************************************************
 * 프로그램명 : FoodinfoActivity.java
 * 작성자 : 2016039077 전현성
 * 작성일 : 2020.05.28
 * 프로그램설명 : 쿠폰 클릭시 쿠폰에 대한 정보를 위한 java 파일
 *************************************************/


/*********************************************  2016039077 전현성  ***********************************************/
package com.example.dasse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class FoodinfoActivity extends AppCompatActivity {

    FirebaseDatabase dataBase = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodinfo);
        // 상품 정보에 해당하는 xml 호출
        ImageView foodImage = (ImageView) findViewById(R.id.activity_foodinfo_imageview_food);
        TextView storeName = (TextView) findViewById(R.id.activity_foodinfo_textview_store_name);
        TextView menuName = (TextView) findViewById(R.id.activity_foodinfo_textview_store_menu_name);
        TextView oldPrice = (TextView) findViewById(R.id.activity_foodinfo_textview_menu_old_price);
        TextView discountPrice = (TextView) findViewById(R.id.activity_foodinfo_textview_menu_discount_price);
        TextView foodInfo = (TextView) findViewById(R.id.activity_foodinfo_textview_info);
        TextView storeLocation = (TextView) findViewById(R.id.activity_foodinfo_textview_store_location);

        // 전달받은 intent 호출
        Intent intent = getIntent();

        // 전달받은 정보 xml 연동
        int sFoodImage = intent.getExtras().getInt("ImgID");
        String sStoreName = intent.getExtras().getString("StoreName");
        String sMenuName = intent.getExtras().getString("MenuName");
        String sOldPrice = intent.getExtras().getString("OldPrice");
        String sDiscountPrice = intent.getExtras().getString("DiscountPrice");
        String sFoodInfo = intent.getExtras().getString("FoodInfo");
        String sStoreLocation = intent.getExtras().getString("StoreLocation");

        foodImage.setImageResource(sFoodImage);
        storeName.setText(sStoreName);
        menuName.setText(sMenuName);
        oldPrice.setText(sOldPrice);
        discountPrice.setText(sDiscountPrice);
        foodInfo.setText(sFoodInfo);
        storeLocation.setText(sStoreLocation);


    }
}

/*********************************************  2016039077 전현성  ***********************************************/
