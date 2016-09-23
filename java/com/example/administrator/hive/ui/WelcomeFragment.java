package com.example.administrator.hive.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.hive.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/9/4.
 */
public class WelcomeFragment extends Fragment {
    public static String mUserName;
    private Activity a;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.welcome_page, container,false);
        TextView ip = (TextView) view.findViewById(R.id.ipAd);
        ip.setText(getIP());
        TextView wname = (TextView) view.findViewById(R.id.welcome_name);
        wname.setText(mUserName);
        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if (context instanceof Activity){
            a = (Activity) context;
        }
    }

    // Gets IP :)
    public String getIP() {
        WifiManager wifiService;

        if (getActivity() != null){
            wifiService = (WifiManager) a.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiinfo = wifiService.getConnectionInfo();
            return intToIp(wifiinfo.getIpAddress());
        } else{
            return("0.0.0.0:Null");
        }


    }

    private static String intToIp(int i) {

        return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF)
                + "." + (i >> 24 & 0xFF);
    }

    public static void load(Context c) {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = c.openFileInput("user");
            reader = new BufferedReader(new InputStreamReader(in));
            mUserName = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
