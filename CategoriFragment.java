package com.example.dasse;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.dasse.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/*************************************************
 * 프로그램명 : CategoriFragment.java
 * 작성자 : 2016039084 신한솔
 * 작성일 : 2020.05.28
 * 프로그램설명 : Categori를 보여주는 Fragment Class
 *************************************************/

/*********************************************  2016039084 신한솔  ***********************************************/
public class CategoriFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    ViewPager pager;

    public CategoriFragment() {
        // Required empty public constructor
    }


    public static CategoriFragment newInstance(String param1, String param2) {
        CategoriFragment fragment = new CategoriFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ImageButton btn[]=new ImageButton[6];
        View rootView = inflater.inflate(R.layout.fragment_categori,container,false);
        btn[0]= (ImageButton)rootView.findViewById(R.id.imageButton1);
        btn[1]= (ImageButton)rootView.findViewById(R.id.imageButton2);
        btn[2]= (ImageButton)rootView.findViewById(R.id.imageButton3);
        btn[3]= (ImageButton)rootView.findViewById(R.id.imageButton4);
        btn[4]= (ImageButton)rootView.findViewById(R.id.imageButton5);
        btn[5]= (ImageButton)rootView.findViewById(R.id.imageButton6);


        btn[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                ((MainActivity) getActivity()).callother(0);
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                ((MainActivity) getActivity()).callother(1);
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                ((MainActivity) getActivity()).callother(2);
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                ((MainActivity) getActivity()).callother(3);
            }
        });

        btn[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                ((MainActivity) getActivity()).callother(4);
            }
        });

        btn[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                ((MainActivity) getActivity()).callother(5);
            }
        });
        /*************************************************
         * 프로그램명 : CategoriFragment.java
         * 작성자 : 2016039077 전현성
         * 작성일 : 2020.06.11
         * 프로그램설명 : 메인 Fragment 하단의 아이템을 위한 코드
         *************************************************/

/*********************************************  2016039077 전현성  ***********************************************/
        // XML 호출
        final ImageButton foodImage = (ImageButton) rootView.findViewById(R.id.fragment_categori_menu_image1);
        final TextView storeName = (TextView) rootView.findViewById(R.id.fragment_categori_store_name1);
        final TextView menuName = (TextView) rootView.findViewById(R.id.fragment_categori_menu_name1);
        final TextView oldPrice = (TextView) rootView.findViewById(R.id.fragment_categori_old_price1);
        final TextView discountPrice = (TextView) rootView.findViewById(R.id.fragment_categori_discount_price1);

        final ImageButton foodImage2 = (ImageButton) rootView.findViewById(R.id.fragment_categori_menu_image2);
        final TextView storeName2 = (TextView) rootView.findViewById(R.id.fragment_categori_store_name2);
        final TextView menuName2 = (TextView) rootView.findViewById(R.id.fragment_categori_menu_name2);
        final TextView oldPrice2 = (TextView) rootView.findViewById(R.id.fragment_categori_old_price2);
        final TextView discountPrice2 = (TextView) rootView.findViewById(R.id.fragment_categori_discount_price2);

        // 호출한 xml에 데이터 세팅
        foodImage.setImageResource(R.drawable.cbibimbob);
        storeName.setText("꼬막상회");
        menuName.setText("꼬막비빔밥");
        oldPrice.setText("12,000₩");
        discountPrice.setText("10,000₩");

        foodImage2.setImageResource(R.drawable.gambas);
        storeName2.setText("청춘호텔");
        menuName2.setText("감바스");
        oldPrice2.setText("23,000₩");
        discountPrice2.setText("21,500₩");


        // 첫번째 정보를 눌렀을 때
        foodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoodinfoActivity.class);
                intent.putExtra("ImgID",R.drawable.cbibimbob);
                intent.putExtra("StoreName","꼬막상회");
                intent.putExtra("MenuName","꼬막비빔밥");
                intent.putExtra("OldPrice","12,000₩");
                intent.putExtra("DiscountPrice","10,000₩");
                intent.putExtra("FoodInfo","신선한 꼬막 비빔밥 1인분");
                intent.putExtra("StoreLocation","충청북도 청주시 흥덕구 복대2동 내수동로 32");
                startActivity(intent);
            }
        });

        // 두번째 정보를 눌렀을 때
        foodImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoodinfoActivity.class);
                intent.putExtra("ImgID",R.drawable.gambas);
                intent.putExtra("StoreName","청춘호텔");
                intent.putExtra("MenuName","감바스 알 아히요");
                intent.putExtra("OldPrice","23,000₩");
                intent.putExtra("DiscountPrice","21,500₩");
                intent.putExtra("FoodInfo","감바스 알 아히요 2인");
                intent.putExtra("StoreLocation","충청북도 청주시 서원구 사직대로 227");
                startActivity(intent);
            }
        });


/*********************************************  2016039077 전현성  ***********************************************/

        // Inflate the layout for this fragment
        return rootView;

    }
}

/*********************************************  2016039084 신한솔  ***********************************************/