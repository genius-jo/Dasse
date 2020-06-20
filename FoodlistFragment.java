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

public class FoodlistFragment extends ListFragment {

    MemberDataAdapter adapter;

    ArrayList<MemberData> datas= new ArrayList<MemberData>();

    ListView listview;

    /*************************************************
     * 프로그램명 : onCreateView()
     * 작성자 : 2016039084 신한솔
     * 작성일 : 2020.05.30
     * 프로그램설명 : 쿠폰정보를 출력하는 onCreatView
     *************************************************/

    /*********************************************  2016039084 신한솔  ***********************************************/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //adapter = new MemberDataAdapter();

        datas.add( new MemberData("꼬불꼬불", "치즈닭갈비 2인 세트" ,"16,000₩", "13,000₩",
                " 치즈닭갈비 2인 \n 콜라 L ", "충북 청주시 서원구 내수동로 143 1층", R.drawable.food1));
        datas.add( new MemberData("봉구스 밥버거", "치즈제육 밥버거 세트", "4,800₩","3,500₩",
                " 치즈제육 밥버거 \n 아메리카노 or 탄산 선택", "충북 청주시 상당구 산성로98번길 18",R.drawable.food2));
        datas.add( new MemberData("아웃닭", "마늘치킨 세트", "13,000₩", "10,000₩",
                " 마늘치킨 \n 탄산","충북 청주시 서원구 1순환로672번길 51", R.drawable.food3));
        datas.add( new MemberData("일미닭갈비", "직화닭갈비 2인 세트", "14,000₩", "10,000₩",
                " 직화닭갈비 2인 \n 탄산","충북 청주시 상당구 용암북로168번길 42-6",R.drawable.food4));
        datas.add( new MemberData("서양다방", "커플세트", "25,000₩", "20,500₩",
                " 포모도로 파스타 \n 피자 \n 빙수 \n 디저트 \n 음료", "충북 청주시 서원구 내수동로108번길 28", R.drawable.food5));


        MemberDataAdapter adapter= new MemberDataAdapter(getLayoutInflater(), datas);
        setListAdapter(adapter);


        return super.onCreateView(inflater,container,savedInstanceState);
    }
    /*********************************************  2016039084 신한솔  ***********************************************/

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
