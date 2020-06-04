package com.example.dasse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.dasse.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoriFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoriFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriFragment newInstance(String param1, String param2) {
        CategoriFragment fragment = new CategoriFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ImageButton btn[]=new ImageButton[7];
        View rootView = inflater.inflate(R.layout.fragment_categori,container,false);
        btn[0]= (ImageButton)rootView.findViewById(R.id.imageButton1);
        btn[1]= (ImageButton)rootView.findViewById(R.id.imageButton2);
        btn[2]= (ImageButton)rootView.findViewById(R.id.imageButton3);
        btn[3]= (ImageButton)rootView.findViewById(R.id.imageButton4);
        btn[4]= (ImageButton)rootView.findViewById(R.id.imageButton5);
        btn[5]= (ImageButton)rootView.findViewById(R.id.imageButton6);
        btn[6]= (ImageButton)rootView.findViewById(R.id.imageButton7);

        btn[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v1){
                MainActivity activity = (MainActivity)getActivity();
                activity.onFragmentChanged(1);
            }
        });

        /*View.OnClickListener listener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity activity = (MainActivity)getActivity();
                activity.onFragmentChanged(1);
                Toast.makeText(getActivity(), "성공", Toast.LENGTH_SHORT).show();
            }
        };*/
        View.OnClickListener listener2 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "food", Toast.LENGTH_SHORT).show();
            }
        };
        View.OnClickListener listener3 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "cafe", Toast.LENGTH_SHORT).show();
            }
        };
        View.OnClickListener listener4 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "bar", Toast.LENGTH_SHORT).show();
            }
        };
        View.OnClickListener listener5 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "play", Toast.LENGTH_SHORT).show();
            }
        };
        View.OnClickListener listener6 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "study", Toast.LENGTH_SHORT).show();
            }
        };
        View.OnClickListener listener7 = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "etc", Toast.LENGTH_SHORT).show();
            }
        };
       // btn[0].setOnClickListener(listener1);
        btn[1].setOnClickListener(listener2);
        btn[2].setOnClickListener(listener3);
        btn[3].setOnClickListener(listener4);
        btn[4].setOnClickListener(listener5);
        btn[5].setOnClickListener(listener6);
        btn[6].setOnClickListener(listener7);

        // Inflate the layout for this fragment
        return rootView;

    }
}
