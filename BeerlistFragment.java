package com.example.dasse;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

/*************************************************
 * 프로그램명 : BeerlistFragment.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.06.01
 * 프로그램설명 : Beerlist를 보여주는 Fragment
 *************************************************/

/*********************************************  2016039066 조광식  ***********************************************/

public class BeerlistFragment extends ListFragment {

    MemberDataAdapter adapter;

    //리스트 형태로 데이터 저장
    ArrayList<MemberData> datas= new ArrayList<MemberData>();

    ListView listview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //adapter = new MemberDataAdapter();

        //데이터 삽입
        datas.add( new MemberData("새벽술집", "김치찌개" ,"8,000₩", "5,900₩",
                "김치찌개 (소주 서비스)", "충북 청주시 서원구 개신로 143 2층", R.drawable.beer1));
        datas.add( new MemberData("지리산", "해물 파전", "13,000₩","12,000₩",
                "해물 파전 (막걸리 서비스)", "충북 청주시 흥덕구 내수동로50번길 75",R.drawable.beer2));
        datas.add( new MemberData("최고 전집", "감자전", "10,000₩", "7,000₩",
                "감자전","충북 청주시 흥덕구 성봉로 275", R.drawable.beer3));
        datas.add( new MemberData("닭꼬치 이야기", "모듬 꼬치", "8,500₩", "5,500₩",
                "모듬 꼬치 (테이크 아웃)","충북 청주시 서원구 예체로 100",R.drawable.beer4));
        datas.add( new MemberData("옛날 전골", "모듬 전골", "25,000₩", "23,500₩",
                "모듬 전골 (소주 서비스)", "충북 청주시 서원구 개신로 11", R.drawable.beer5));


        //adapter 생성
        MemberDataAdapter adapter= new MemberDataAdapter(getLayoutInflater(), datas);
        setListAdapter(adapter);


        return super.onCreateView(inflater,container,savedInstanceState);
    }
/*********************************************  2016039066 조광식  ***********************************************/

    /*************************************************
     * 프로그램명 : onListItemClick()
     * 작성자 : 2016039077 전현성
     * 작성일 : 2020.05.28
     * 프로그램설명 : 쿠폰 클릭시 정보 Activity로 데이터를 넘겨주는 함수
     *************************************************/

    /*********************************************  2016039077 전현성  ***********************************************/
    @Override
    public void onListItemClick(ListView l, View v,int position, long id){
        // MenberData 변수 선언
        MemberData item = (MemberData) l.getItemAtPosition(position);

        // 변수에 데이터 넣기
        String storeName = item.getStoreName();
        String menuName = item.getMenuName();
        String oldPrice = item.getOldPrice();
        String discountPrice = item.getDiscountPrice();
        String foodInfo = item.getFoodInfo();
        String storeLocation = item.getStoreLocation();
        int imgId = item.getImgId();

        // 전달할 Intent에 정보 삽입
        Intent intent = new Intent(getActivity(), FoodinfoActivity.class);
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


