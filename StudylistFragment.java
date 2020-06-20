package com.example.dasse;
/*************************************************
 * 프로그램명 : StudylistFragment.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.06.03
 * 프로그램설명 : playlist를 보여주는 Fragment Class
 *************************************************/

/*********************************************  2016039066 조광식  ***********************************************/

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class StudylistFragment extends ListFragment {

    MemberDataAdapter adapter;

    //리스트 형태로 데이터 저장
    ArrayList<MemberData> datas= new ArrayList<MemberData>();

    ListView listview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //adapter = new MemberDataAdapter();

        //가게 데이터 삽입
        datas.add( new MemberData("한국 외국어 학원", "1달 프리패스" ,"200,000₩", "160,000₩",
                "1달 프리패스 (토익)", "충북 청주시 서원구 개신로 100 2층", R.drawable.study1));
        datas.add( new MemberData("홍쌤 토익", "1년 프리패스", "1,800,000₩","1,600,000₩",
                "1년 프리패스 (토익)", "충북 청주시 흥덕구 내수동로55번길 15",R.drawable.study2));
        datas.add( new MemberData("집중 독서실", "1달 이용권", "100,000₩", "80,000₩",
                "1달 이용권 (자유석)","충북 청주시 흥덕구 성봉로 277", R.drawable.study3));
        datas.add( new MemberData("A+ 독서실", "1년 이용권", "900,000₩", "700,000₩",
                "1년 이용권 (지정석)","충북 청주시 서원구 개신로 55 2층",R.drawable.study4));
        datas.add( new MemberData("내가 최고 독서실", "3달 이용권", "250,000₩", "230,000₩",
                "3달 이용권 (자유석)", "충북 청주시 서원구 개신로 20 3층", R.drawable.study5));


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
