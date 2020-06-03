/* **********************************************
 * 프로그램명 : CuponlistFragment.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.05.25
 *프로그램 설명 : 쿠폰 데이터 리스트의 프래그먼트
 ************************************************/
package com.example.dasse;

import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;

public class CuponlistFragment extends ListFragment {

    CuponDataAdapter adapter;

    //배열로 보관하기 위한 ArrayList 객체 생성
    ArrayList<CuponData> datas= new ArrayList<CuponData>();

    //ListView 참조변수
    ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        datas.add(new CuponData("쿠폰리스트 테스트1","50% 할인", R.drawable.hotdog));
        datas.add( new CuponData("쿠폰리스트 테스트2", "60% 할인",  R.drawable.toast));
        datas.add( new CuponData("쿠폰리스트 테스트3", "70% 할인",  R.drawable.dakbal));
        datas.add( new CuponData("쿠폰리스트 테스트4", "5% 할인",  R.drawable.psybuger));

        //ListView 객체 찾아와서 참조
        //AdapterView의 일종인 ListView에 적용할 Adapter 객체 생성
        //Data 객체의 정보들을 적절하게 보여줄 뷰로 만들어주는 Adapter클래스 객체생성
        //첫번재 파라미터로 xml 레이아웃 파일을 객체로 만들어 주는 LayoutInflater 객체 얻어와서 전달.
        //두번째 파라미터는  Data 배열.
        CuponDataAdapter adapter= new CuponDataAdapter(getLayoutInflater(), datas);
        setListAdapter(adapter);

        //Adapter 객체를 AdapterView의 일종인 ListView에 설정.
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v,int position, long id){
        CuponData item = (CuponData) l.getItemAtPosition(position);

        String titleStr = item.getStoreName();
        String descStr = item.getCuponName();
        int iconDrawable = item.getImgId();
    }

}
