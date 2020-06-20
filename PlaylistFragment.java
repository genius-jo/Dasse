package com.example.dasse;

/*************************************************
 * 프로그램명 : PlaylistFragment.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.06.03
 * 프로그램설명 : playlist를 보여주는 Fragment
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

public class PlaylistFragment extends ListFragment {

    MemberDataAdapter adapter;

    //리스트 형태로 데이터 저장
    ArrayList<MemberData> datas= new ArrayList<MemberData>();

    ListView listview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //adapter = new MemberDataAdapter();

        //가게 데이터 삽입
        datas.add( new MemberData("Fun 게임", "플레이 스테이션 이용권" ,"5,000₩", "2,900₩",
                "플레이스테이션 이용권 (1시간)", "충북 청주시 서원구 개신로 3 4층", R.drawable.play1));
        datas.add( new MemberData("슈퍼 방탈출", "2인 이용권", "50,000₩","32,000₩",
                "2인 이용권", "충북 청주시 흥덕구 내수동로 22번길 15",R.drawable.play2));
        datas.add( new MemberData("나는 가수 노래방", "2시간 이용권", "10,000₩", "8,000₩",
                "2시간 이용권","충북 청주시 흥덕구 성봉로 3", R.drawable.play3));
        datas.add( new MemberData("레츠고 방탈출", "4인 이용권", "90,000₩", "75,500₩",
                "4인 이용권","충북 청주시 서원구 개신로 5 2층",R.drawable.play4));
        datas.add( new MemberData("부르자 노래방", "1시간 이용권", "4,000₩", "3,500₩",
                "부르자 노래방", "충북 청주시 서원구 개신로 122", R.drawable.play5));


        //adapter생성
        MemberDataAdapter adapter= new MemberDataAdapter(getLayoutInflater(), datas);
        setListAdapter(adapter);


        return super.onCreateView(inflater,container,savedInstanceState);
    }
/*********************************************  2016039066 조광식  ***********************************************/

    /*************************************************
     * 프로그램명 : PlaylistFragment.java
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
