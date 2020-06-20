package com.example.dasse;
/*************************************************
 * 프로그램명 : CouponlistFragment.java
 * 작성자 : 2016039077 전현성 2016039066 조광식
 * 작성일 : 2020.06.06
 * 프로그램설명 : 쿠폰 정보들의 리스트 관리
 *************************************************/

/*********************************************  2016039077 전현성  ***********************************************/
/*********************************************  2016039066 조광식  ***********************************************/
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CouponlistFragment extends ListFragment {

    CouponDataAdapter adapter;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    private FirebaseAuth firebaseAuth;

    // 정보 저장을 위한 리스트 생성
    ArrayList<CouponData> datas= new ArrayList<CouponData>();
    CouponData couponData;

    //ListView 참조변수
    ListView listview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Firebase를 통해 uid 설정
        firebaseAuth = FirebaseAuth.getInstance();
        final String myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // 쿠폰이 저장되는 위치로 접근 후 추가/삭제에 대한 이벤트 발생 대기
        databaseReference.child("Users").child(myUid).child("HaveCoupon").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    // DataSnapshot을 이용하여 데이터의 갯수만큼 불러옴
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        couponData = snapshot.getValue(CouponData.class);
                        datas.add(couponData);
                        //데이터가 없으면 break
                        if (couponData.toString() == "0"){
                            break;
                        }

                        //불러온 데이터를 Adapter로 전달
                        CouponDataAdapter adapter= new CouponDataAdapter(getLayoutInflater(), datas);
                        setListAdapter(adapter);


                    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }



        });

        //Adapter로부터 데이터 전달
        CouponDataAdapter adapter= new CouponDataAdapter(getLayoutInflater(), datas);
        setListAdapter(adapter);

        //위에 만든 Adapter 객체를 AdapterView의 일종인 ListView에 설정.
        return super.onCreateView(inflater,container,savedInstanceState);
    }
    /*********************************************  2016039066 조광식  ***********************************************/
    //리스트 클릭 시
    @Override
    public void onListItemClick(ListView l, View v,int position, long id){

        // CouponData 변수 선언
        CouponData item = (CouponData) l.getItemAtPosition(position);

        // 변수에 데이터 넣기
        String storeName = item.getStoreName();
        String menuName = item.getMenuName();
        String oldPrice = item.getOldPrice();
        String discountPrice = item.getDiscountPrice();
        String foodInfo = item.getFoodInfo();
        String storeLocation = item.getStoreLocation();
        String imgId = Integer.toString(item.getImgId());

        // 전달할 Intent에 정보 삽입
        Intent intent = new Intent(getActivity(), FoodinfoBarcodeActivity.class);
        intent.putExtra("ImgID",imgId);
        intent.putExtra("StoreName",storeName);
        intent.putExtra("MenuName",menuName);
        intent.putExtra("OldPrice",oldPrice);
        intent.putExtra("DiscountPrice",discountPrice);
        intent.putExtra("FoodInfo",foodInfo);
        intent.putExtra("StoreLocation",storeLocation);

        startActivity(intent);

    }


}
/*********************************************  2016039077 전현성  ***********************************************/