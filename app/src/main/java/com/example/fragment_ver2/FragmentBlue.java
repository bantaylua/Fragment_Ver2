package com.example.fragment_ver2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentBlue extends Fragment {
    MainActivity main;
    Context context = null;
    String message = "";

//    private String items[] = {"A1_9829", "A1_1809", "A2_3509",
//            "A2_3100", "A1_1120", "A3_4120",
//            "A2_8100", "A4_1160", };
    // test list view image
    private String[] items = new String[] {"A1_9829", "A1_1809", "A2_3509",
                "A2_3100", "A1_1120", "A3_4120",
                "A2_8100", "A4_1160",};

    private int[] listviewImage = new int[]{
            R.drawable.avatar_1, R.drawable.avatar_2, R.drawable.avatar_3,
            R.drawable.avatar_4, R.drawable.avatar_5, R.drawable.avatar_6,
            R.drawable.avatar_7, R.drawable.avatar_8,
    };



    // end of test

    public static FragmentBlue newInstance(String strArg) {
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            context = getActivity();
            main = (MainActivity) getActivity();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("MainActivity must implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout_blue = (LinearLayout) inflater.inflate(R.layout.layout_blue, null);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 8; i++){
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("ma_so", items[i]);
            hm.put("hinh_anh", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }
        String[] from = {"ma_so", "hinh_anh"};
        int[] to = {R.id.listview_title, R.id.listview_image};
        //SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.layout_image, from, to);
        //ListView androidListView = (ListView) findViewbyId(R.id.listViewBlue);
        //androidListView.setAdapter(simpleAdapter);

        final TextView txtBlue = (TextView) layout_blue.findViewById(R.id.textView1Blue);
        ListView listView = (ListView) layout_blue.findViewById(R.id.listViewBlue);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));

        ArrayAdapter adapter = new ArrayAdapter (context,
                android.R.layout.simple_list_item_1, items);
        //ArrayAdapter<List<HashMap<String, String>>> adapter = new ArrayAdapter<>(context,                )
        listView.setAdapter(adapter);
        listView.setSelection(0);
        listView.smoothScrollToPosition(0);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                main.onMsgFromFragToMain("BLUE-FRAG", "Mã số: " + items[position]);
                txtBlue.setText("Mã số: " + items[position]);
            }
        });
        return layout_blue;
    }
}
