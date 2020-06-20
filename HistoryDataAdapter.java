package com.example.dasse;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/*************************************************
 * 프로그램명 : HistoryDataAdapter.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.06.02
 * 프로그램설명 : 이용내역 정보들을 지정된 형태로 화면에 뿌린다
 *************************************************/
/*********************************************  2016039066 조광식  ***********************************************/

//extends BaseAdapter;
public class HistoryDataAdapter extends BaseAdapter {
    ArrayList<HistoryData> datas;

    LayoutInflater inflater; //XML에 있는걸 화면에 가져오는거

    public HistoryDataAdapter(LayoutInflater inflater, ArrayList<HistoryData> datas) {

        //멤버 데이터로 전송
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


    //전달받은 position를 그대로 리턴함.
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    /*********************************************  2016039066 조광식  ***********************************************/
/*************************************************
 * 프로그램명 : HistoryDataAdapter.java
 * 작성자 : 2016039077 전현성
 * 작성일 : 2020.06.06
 * 프로그램설명 : 사용된 쿠폰 정보들의 객체 생성
 *************************************************/

/*********************************************  2016039077 전현성  ***********************************************/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if( convertView==null){
            //null이라면 View가 없으므로 새로운 객체 생성
            convertView= inflater.inflate(R.layout.historylist_row, null);
        }

        //객체를 위한 xml 호출
        TextView text_store_name= (TextView)convertView.findViewById(R.id.text_store_name);
        TextView text_menu_name= (TextView)convertView.findViewById(R.id.text_store_menu_name);
        TextView text_old_price= (TextView)convertView.findViewById(R.id.text_menu_old_price);
        TextView text_discount_price= (TextView)convertView.findViewById(R.id.text_menu_discount_price);
        TextView history_row_usedtime = (TextView)convertView.findViewById(R.id.history_row_usedtime);

        ImageView img_flag= (ImageView)convertView.findViewById(R.id.img_flag);

        //호출한 xml의 데이터를 set
        text_store_name.setText( datas.get(position).getStoreName() );
        text_menu_name.setText( datas.get(position).getMenuName() );
        text_old_price.setText( datas.get(position).getOldPrice() );
        text_discount_price.setText( datas.get(position).getDiscountPrice() );
        history_row_usedtime.setText(datas.get(position).getUsedTime() + " 사용됨");
        img_flag.setImageResource( datas.get(position).getImgId() );

        //설정이 끝난 convertView객체 리턴
        return convertView;
    }
}
/*********************************************  2016039077 전현성  ***********************************************/