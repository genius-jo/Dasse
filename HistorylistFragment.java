package com.example.dasse;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

/*************************************************
 * 프로그램명 : HistorylistFragment.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.06.03
 * 프로그램설명 : Historylist를 보여주는 Fragment Class
 *************************************************/

/*********************************************  2016039066 조광식  ***********************************************/

public class HistorylistFragment extends ListFragment {

    HistoryDataAdapter adapter;
    HistoryData historyData;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    private FirebaseAuth firebaseAuth;


    //리스트 형태로 데이터 저장
    ArrayList<HistoryData> datas= new ArrayList<HistoryData>();


    ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //adapter생성
        HistoryDataAdapter adapter= new HistoryDataAdapter(getLayoutInflater(), datas);
        setListAdapter(adapter);
        /*********************************************  2016039066 조광식  ***********************************************/
/*************************************************
* 프로그램명 : HistorylistFragment.java
* 작성자 : 2016039077 전현성
* 작성일 : 2020.06.06
* 프로그램설명 : 사용한 쿠폰을 출력하기 위한 java 파일
*************************************************/
/*******************************************  2016039077 전현성  ***********************************************/

        firebaseAuth = FirebaseAuth.getInstance();
        final String myUid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        databaseReference.child("Users").child(myUid).child("UsedCoupon").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    historyData = snapshot.getValue(HistoryData.class);
                    datas.add(historyData);

                    HistoryDataAdapter adapter= new HistoryDataAdapter(getLayoutInflater(), datas);
                    setListAdapter(adapter);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }



        });









        //위에 만든 Adapter 객체를 AdapterView의 일종인 ListView에 설정.
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v,int position, long id){
        // MenberData 변수 선언
        HistoryData item = (HistoryData) l.getItemAtPosition(position);

        // 변수에 데이터 넣기
        String storeName = item.getStoreName();
        String menuName = item.getMenuName();
        String oldPrice = item.getOldPrice();
        String discountPrice = item.getDiscountPrice();
        String foodInfo = item.getFoodInfo();
        String storeLocation = item.getStoreLocation();
        String imgId = Integer.toString(item.getImgId());
        String usedTime = item.getUsedTime();
        // 전달할 Intent에 정보 삽입
        Intent intent = new Intent(getActivity(), FoodinfoUsedActivity.class);
        intent.putExtra("ImgID",imgId);
        intent.putExtra("StoreName",storeName);
        intent.putExtra("MenuName",menuName);
        intent.putExtra("OldPrice",oldPrice);
        intent.putExtra("DiscountPrice",discountPrice);
        intent.putExtra("FoodInfo",foodInfo);
        intent.putExtra("StoreLocation",storeLocation);
        intent.putExtra("UsedTime",usedTime);

        startActivity(intent);

    }


}

/*******************************************  2016039077 전현성  ***********************************************/