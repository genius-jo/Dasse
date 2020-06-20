package com.example.dasse;
/*************************************************
 * 프로그램명 : MemberDataAdapter.java
 * 작성자 : 2016039066 조광식 2016039084 신한솔
 * 작성일 : 2020.06.02
 * 프로그램설명 : 쿠폰 정보들을 지정된 xml의 형태로 화면에 뿌린다
 *************************************************/
/*********************************************  2016039066 조광식 2016039084 신한솔 ***********************************************/
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


//extends BaseAdapter;
public class MemberDataAdapter extends BaseAdapter {
    ArrayList<MemberData> datas;
    LayoutInflater inflater; //XML에 있는걸 화면에 가져오는거


    public MemberDataAdapter(LayoutInflater inflater, ArrayList<MemberData> datas) {
        // TODO Auto-generated constructor stub
        this.datas= datas;

        this.inflater= inflater;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return datas.size(); //datas의 개수를 리턴
    }


    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return datas.get(position);//datas의 특정 인덱스 위치 객체 리턴.
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if( convertView==null){
            convertView= inflater.inflate(R.layout.list_row, null);
        }
/*********************************************  2016039066 조광식  ***********************************************/

/*************************************************
 * 프로그램명 : MemberDataAdapter.java
 * 작성자 : 2016039077 전현성
 * 작성일 : 2020.06.06
 * 프로그램설명 : 사용된 쿠폰 정보들의 객체 생성
 *************************************************/

/*********************************************  2016039077 전현성  ***********************************************/
        TextView text_store_name= (TextView)convertView.findViewById(R.id.text_store_name);
        TextView text_menu_name= (TextView)convertView.findViewById(R.id.text_store_menu_name);
        TextView text_old_price= (TextView)convertView.findViewById(R.id.text_menu_old_price);
        TextView text_discount_price= (TextView)convertView.findViewById(R.id.text_menu_discount_price);
        ImageView img_flag= (ImageView)convertView.findViewById(R.id.img_flag);

        //현재 position( getView()메소드의 첫번재 파라미터 )번째의 Data를 위 해당 View들에 연결..
        text_store_name.setText( datas.get(position).getStoreName() );
        text_menu_name.setText( datas.get(position).getMenuName() );
        text_old_price.setText( datas.get(position).getOldPrice() );
        text_discount_price.setText( datas.get(position).getDiscountPrice() );
        img_flag.setImageResource( datas.get(position).getImgId() );

        //설정이 끝난 convertView객체 리턴(ListView에서 목록 하나.)
        return convertView;
    }
}

/*********************************************  2016039077 전현성  ***********************************************/