package com.example.dasse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*************************************************
 * 프로그램명 : CouponDataAdapter.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.05.03
 * 프로그램설명 : 데이터 정보들을 지정된 형태로 화면에 뿌린다
 *************************************************/
/*********************************************  2016039066 조광식  ***********************************************/

public class CouponDataAdapter extends BaseAdapter {
    ArrayList<CouponData> datas;
    LayoutInflater inflater; //XML에 있는걸 화면에 가져온다

    public CouponDataAdapter(LayoutInflater inflater, ArrayList<CouponData> datas) {
        // TODO Auto-generated constructor stub

        this.datas= datas;

        //couponlist_row.xmll 파일을 View 객체로 생성
        //이 CuponDataAdapter 클래스를 객체로 만들어내는 클래스에서 LayoutInflater 객체 전달
        this.inflater= inflater;
    }

    //ListView에서 이 CuponDataAdapter 객체에게 요청하는 값으로서
    //CuponDataAdapter 객체가 만들어낼 View의 개수를 리턴
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return datas.size(); //datas의 개수를 리턴
    }

    //CuponDataAdapter 특정 위치(position)에 해당하는 Data를 리턴하는 메소드
    //datas의 특정위치에 해당하는  CuponData 객체를 리턴.
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return datas.get(position);//datas의 특정 인덱스 위치 객체 리턴.
    }

    //전달받은 position를 그대로 리턴함.
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    //ListView에서 한 항목의 View 모양과 값을 설정
    //position : ListView에 놓여질 목록의 위치.
    //convertview : 리턴될 View로서 List의 한 항목의 View 객체
    //parent : 이 Adapter 객체가 설정된 AdapterView객체
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        //New View
        if( convertView==null){
            //xml로 선언된 레이아웃 파일을 객체로 부풀려주는 LayoutInflater 객체 활용.
            convertView= inflater.inflate(R.layout.couponlist_row, null);
        }

        // Bind View
        //convertView로 부터 findViewById()
        TextView text_store_name= (TextView)convertView.findViewById(R.id.text_store_name);
        TextView text_menu_name= (TextView)convertView.findViewById(R.id.text_coupon_name);
        ImageView img_flag= (ImageView)convertView.findViewById(R.id.img_flag);

        //현재 Data를 위 해당 View에 연결
        text_store_name.setText( datas.get(position).getStoreName() );
        text_menu_name.setText( datas.get(position).getMenuName()+" 할인" );
        img_flag.setImageResource(datas.get(position).getImgId());

        //설정이 끝난 convertView객체 리턴
        return convertView;
    }
}
/*********************************************  2016039066 조광식  ***********************************************/
