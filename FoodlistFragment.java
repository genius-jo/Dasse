package com.example.dasse;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class FoodlistFragment extends ListFragment {

    MemberDataAdapter adapter;

    ArrayList<MemberData> datas= new ArrayList<MemberData>();

    ListView listview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //adapter = new MemberDataAdapter();

        datas.add( new MemberData("킴스부리또", "2인 세트" ,"9,800₩", "8,900₩",
                "킴스부리또 2개 \n 콜라 M 2잔", "충북 청주시 서원구 내수동로 143 2층", R.drawable.burrito));
        datas.add( new MemberData("평민 닭발", "국물닭발", "16,000₩","14,600₩",
                "국물닭발 \n 사이드메뉴 선택", "충북 청주시 상당구 산성로98번길 18",R.drawable.dakbal));
        datas.add( new MemberData("맛존매콤닭갈비", "매콤닭갈비 커플", "24,000₩", "22,000₩",
                "닭갈비 2인분 (맵기 선택 가능)","충북 청주시 서원구 1순환로672번길 51", R.drawable.dakgarlbi));
        datas.add( new MemberData("자담돈", "치즈돈까스 2인 세트", "20,000₩", "18,000₩",
                "치즈돈까쓰 2인 \n음료 2잔 (콜라, 사이다)","충북 청주시 상당구 용암북로168번길 42-6",R.drawable.cheesetonkatsu));
        datas.add( new MemberData("일미닭갈비", "닭갈비 코스 A", "32,000₩", "30,000₩",
                "닭갈비 2인분 \n사리 선택 2개 \n음료 선택", "충북 청주시 서원구 내수동로108번길 28", R.drawable.dakbal2));


        MemberDataAdapter adapter= new MemberDataAdapter(getLayoutInflater(), datas);
        setListAdapter(adapter);


        return super.onCreateView(inflater,container,savedInstanceState);
    }

    /*************************************************
     * 프로그램명 : FoodlistFragment.java
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
