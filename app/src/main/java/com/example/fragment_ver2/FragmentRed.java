package com.example.fragment_ver2;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;



public class FragmentRed extends Fragment implements FragmentCallbacks {
    MainActivity main;
    TextView txtRed;
    TextView txtName;
    TextView txtLop;
    TextView txtDiem;
    Button btnRedClock;
    Button btnFirst;
    Button btnPrevious;
    Button btnNext;
    Button btnLast;


    private String[] items = new String[] {"A1_9829", "A1_1809", "A2_3509",
            "A2_3100", "A1_1120", "A3_4120",
            "A2_8100", "A4_1160",};
    Integer[] position = {0,1,2,3,4,5,6,7};
    private String[] hoten = new String[] {"Nguyen Van C", "Le Thi A", "Tran Thi B",
            "Nguyen Tien D", "Trieu Van E", "Tran Tuan F",
            "Nguyen Van G", "Luu Thi H", };

    private  String[] lop = new String[] {"A1", "A1", "A2", "A2", "A1", "A3", "A2", "A4", };

    private int[] diem = new int[] {7, 8, 9, 6, 5, 9, 8, 7};


    public static FragmentRed newInstance(String strArg1) {
        FragmentRed fragment = new FragmentRed();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException(" Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        LinearLayout view_layout_red = (LinearLayout) inflater.inflate(R.layout.layout_red, null);
        txtRed = (TextView) view_layout_red.findViewById(R.id.textView1Red);
        txtName = (TextView) view_layout_red.findViewById(R.id.textViewName);
        txtLop = (TextView) view_layout_red.findViewById(R.id.textViewClass);
        txtDiem = (TextView) view_layout_red.findViewById(R.id.textViewGrade);
        try {
            Bundle arguments = getArguments();
            String redMessage = arguments.getString("arg1", "");
            txtRed.setText(redMessage);
        } catch (Exception e) {
            Log.e("RED BUNDLE ERROR - ", "" + e.getMessage());
        }

//        btnFirst =(Button) view_layout_red.findViewById(R.id.button1Red);
//        btnFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String redMessage = items[0];
//                String redName = hoten[0];
//                String redClass = lop[0];
//                String redGrade = Integer.toString(diem[0]);
//                txtRed.setText(redMessage);
//                txtName.setText(redName);
//                txtLop.setText(redClass);
//                txtDiem.setText(redGrade);
//                main.onMsgFromFragToMain("RED-FRAG", );
//            }
//        });

        btnPrevious = (Button) view_layout_red.findViewById(R.id.buttonPrevious);


        btnNext = (Button) view_layout_red.findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int pos = 0;
                String strPos = "0";
                String redMessage = items[0];
                String redName = hoten[0];
                String redClass = lop[0];
                String redGrade = Integer.toString(diem[0]);
                txtRed.setText(redMessage);
                txtName.setText(redName);
                txtLop.setText(redClass);
                txtDiem.setText(redGrade);
                main.onMsgFromFragToMain("RED-FRAG", redMessage, strPos );
                int pos = getOnMsgFromMainToFragment(redMessage, strPos);
                //String redMessage = items[];
            }
        });

//        btnLast = (Button) view_layout_red.findViewById(R.id.buttonLast);
//        btnLast.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public  void onClick (View view){
//                String redMessage = items [7];
//                String redName = hoten[7];
//                String redClass = lop[7];
//                String redGrade = Integer.toString(diem[7]);
//                txtRed.setText(redMessage);
//                main.onMsgFromFragToMain("RED-FRAG", redMessage);
//            }
//        });

//        btnRedClock = (Button) view_layout_red.findViewById(R.id.button1Red);
//        btnRedClock.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String redMessage = "Red clock: \n" + new Date().toString();
//                txtRed.setText(redMessage);
//                main.onMsgFromFragToMain("RED-FRAG", redMessage);
//            }
//        });
        return view_layout_red;
    }


    @Override
    public void onMsgFromMainToFragment(String strValue, String strPos) {
        txtRed.setText(strValue);


    }


    public int getOnMsgFromMainToFragment (String strValue, String strPos){
        return Integer.getInteger(strPos);
    }
}
