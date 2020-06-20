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
 * 프로그램명 : GuiterlistFragment.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.06.05
 * 프로그램설명 : Guiterlist를 보여주는 Fragment
 *************************************************/

/*********************************************  2016039066 조광식  ***********************************************/

public class GuiterlistFragment extends ListFragment {

    MemberDataAdapter adapter;

    ArrayList<MemberData> datas= new ArrayList<MemberData>();

    ListView listview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //adapter = new MemberDataAdapter();

        datas.add( new MemberData("충대꽃집", "분홍색 꽃" ,"5,000₩", "3,900₩",
                "분홍색꽃 \n (드라이 플라워)", "충북 청주시 서원구 내수동로 111", R.drawable.guiter1));
        datas.add( new MemberData("포토 스튜디오", "증명 사진", "8,000₩","7,000₩",
                "증명사진 (10 매)", "충북 청주시 흥덕구 내수동로 12번길 7",R.drawable.guiter2));

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

