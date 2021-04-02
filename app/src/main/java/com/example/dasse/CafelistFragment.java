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
 * 프로그램명 : CafelistFragment.java
 * 작성자 : 2016039084 신한솔
 * 작성일 : 2020.06.03
 * 프로그램설명 : Categorilist를 보여주는 Fragment Class
 *************************************************/

/*********************************************  2016039084 신한솔  ***********************************************/

public class CafelistFragment extends ListFragment {

    MemberDataAdapter adapter;

    ArrayList<MemberData> datas= new ArrayList<MemberData>();

    ListView listview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //adapter = new MemberDataAdapter();

        datas.add( new MemberData("Arte", "아메리카노 세트" ,"8,000₩", "6,900₩",
                "아미리카노 \n 롤케익", "충북 청주시 서원구 내수동로 143 2층", R.drawable.cafe1));
        datas.add( new MemberData("블루 리프", "달고나 카페라떼", "3,800₩","2,900₩",
                "달고나 카페라떼 (테이크 아웃)", "충북 청주시 흥덕구 내수동로55번길 15",R.drawable.cafe2));
        datas.add( new MemberData("YOLK", "톰과제리 치즈케이크", "10,000₩", "8,000₩",
                "톰과제리 치즈케익크","충북 청주시 흥덕구 성봉로 277", R.drawable.cafe3));
        datas.add( new MemberData("다밀리", "와플 체리콕", "6,500₩", "4,500₩",
                "와플 \n 체리콕","충북 청주시 서원구 예체로 5 다밀리",R.drawable.cafe4));
        datas.add( new MemberData("쿠르쿠르", "딸기 라떼", "5,000₩", "3,500₩",
                "딸기 라떼 (테이크 아웃)", "충북 청주시 서원구 개신로 24", R.drawable.cafe5));


        MemberDataAdapter adapter= new MemberDataAdapter(getLayoutInflater(), datas);
        setListAdapter(adapter);


        return super.onCreateView(inflater,container,savedInstanceState);
    }

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
/*********************************************  2016039084 신한솔  ***********************************************/


