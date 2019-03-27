package com.example.fragment_ver2;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements MainCallbacks {
    FragmentTransaction ft;
    FragmentRed redFragment;
    FragmentBlue blueFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a new blue frag and show it
        ft = getFragmentManager().beginTransaction();
        blueFragment = FragmentBlue.newInstance("first-blue");
        ft.replace(R.id.main_holder_blue, blueFragment);
        ft.commit();

        // create a new red frag and show it
        ft = getFragmentManager().beginTransaction();
        redFragment = FragmentRed.newInstance("first-red");
        ft.replace(R.id.main_holder_red, redFragment);
        ft.commit();

    }

    @Override
    public void onMsgFromFragToMain (String sender, String strValue, String strPos) {
        Toast.makeText(getApplication(),
                "MAIN GOT>>" + sender + "\n" + strValue, Toast.LENGTH_LONG).show();

        if (sender.equals("RED-FRAG")){
            try {
               redFragment.onMsgFromMainToFragment(strValue, strPos);
            } catch (Exception e){
                Log.e("ERROR", "onStrFromFragToMain" + e.getMessage());
            }
        }
        if (sender.equals("BLUE-FRAG")){
            try {
                redFragment.onMsgFromMainToFragment("\nSender: " + sender + "\nMsg:" + strValue, strPos);
            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain" + e.getMessage());
            }
        }
    }


}

