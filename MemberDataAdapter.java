/* **********************************************
 * 프로그램명 : MemberDataAdapter.java
 * 작성자 : 2016039066 조광식
 * 작성일 : 2020.05.20
 *프로그램 설명 : 가게 데이터를 원하는 형태의 View로 바꿔줌
 ************************************************/
package com.example.dasse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MemberDataAdapter extends BaseAdapter {
    ArrayList<MemberData> datas;
    LayoutInflater inflater; //XML에 있는걸 가져오기


    public MemberDataAdapter(LayoutInflater inflater, ArrayList<MemberData> datas) {
        // TODO Auto-generated constructor stub
        //멤버변수로 참조값 전달
        this.datas= datas;

        //list_row.xml 파일을 View 객체로 생성(inflating)
        //이 MemberDataAdapter 클래스를 객체로 만들어내는 클래스에서 LayoutInflater 객체 전달해주야 함.
        this.inflater= inflater;
    }


    //MemberDataAdapter 객체가 만들어낼 View의 개수를 리턴하는 메소드
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return datas.size(); //datas의 개수를 리턴
    }
    //MemberDataAdapter의 특정 위치(position)에 해당하는 Data를 리턴하는 메소드
    //datas의 특정위치에 해당하는  MemberData 객체를 리턴.

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
    //AdapterView의 일종인 ListView는 설정된 Adapter에게
    //대량의 데이터들을 보여주기에 적절한 View로 만들고
    //ListView를 위에 만든 getCount()메소드의 리턴값만큼 getView를 요구하여  목록에 나열함.
    //메소드의 리턴값인 View 가 ListView의 한 항목
    //리턴될 View의 모양을 list_row.xml 파일을 만들어 설계
    //첫번째 파라미터 position : ListView에 놓여질 목록의 위치.
    //두번째 파라미터 convertview : 리턴될 View로서 List의 한 항목의 View 객체
    //세번째 파라미터 parent : 이 Adapter 객체가 설정된 AdapterView객체(ListView)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        //ListView의 목록 하나의 모양을 담당하는 View 객체를 만들어 내는 'New View'
        //convertView 객체가 null인지 확인
        if( convertView==null){
            //null이라면 재활용할 View가 없으므로 새로운 객체 생성
            //View의 모양은 cuponlist_row.xml 파일로 객체를 생성
            //xml로 선언된 레이아웃(layout)파일을 객체로 부풀려주는 LayoutInflater 객체 활용.
            convertView= inflater.inflate(R.layout.list_row, null);
        }

        //만들어진 View에 해당 Data를 연결하는 'Bind View'
        //converView는 View객체 상태
        //이 convertView로부터 데이터를 입력할 것들 참조하기.
        TextView text_store_name= (TextView)convertView.findViewById(R.id.text_store_name);
        TextView text_menu_name= (TextView)convertView.findViewById(R.id.text_store_menu_name);
        TextView text_old_price= (TextView)convertView.findViewById(R.id.text_menu_old_price);
        TextView text_discount_price= (TextView)convertView.findViewById(R.id.text_menu_discount_price);
        ImageView img_flag= (ImageView)convertView.findViewById(R.id.img_flag);

        //현재 position( getView()메소드의 첫번재 파라미터 )번째의 Data를 위 해당 View들에 연결.
        text_store_name.setText( datas.get(position).getStoreName() );
        text_menu_name.setText( datas.get(position).getMenuName() );
        text_old_price.setText( datas.get(position).getOldPrice() );
        text_discount_price.setText( datas.get(position).getDiscountPrice() );
        img_flag.setImageResource( datas.get(position).getImgId() );

        //설정이 끝난 convertView객체 리턴(목록 하나)
        return convertView;
    }
}

