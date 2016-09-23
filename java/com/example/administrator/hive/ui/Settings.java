package com.example.administrator.hive.ui;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hive.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import de.hdodenhof.circleimageview.CircleImageView;


public class Settings extends AppCompatActivity {

    CircleImageView head;
    boolean profileChange = false;
    String mUserName;
    long mProfile;

    String storeUName;
    long storeProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);

        Intent i = getIntent();
        mUserName = i.getStringExtra("Username_Changed");

        load();
        if((i.hasExtra("Changed_name"))
            &&(i.getBooleanExtra("Changed_name",true))){
                mProfile = storeProfile;
            } else {
            mUserName = storeUName;
            mProfile = storeProfile;
        }


        head = (CircleImageView)(findViewById(R.id.Userhead));
        head.setImageResource((int)mProfile);
        TextView userName = (TextView)findViewById(R.id.username);
        userName.setText(mUserName);

        TextView Title = (TextView)(findViewById(R.id.main_Title));
        Title.setText("Settings");

        ImageView buttonRight = (ImageView)findViewById(R.id.buttonRight);
        buttonRight.setImageResource(R.mipmap.edit);
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Click!");
                Intent i = new Intent();
                i.putExtra("Username",mUserName);
                i.setClass(getApplicationContext(), ChangeUsernameActivity.class);
                startActivity(i);
                onStop();
                finish();
            }
        });


        // Now just a series of buttons...
        CircleImageView im1 = (CircleImageView)(findViewById(R.id.Pro1));
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "You've selected Bee!", Toast.LENGTH_SHORT);
                t.show();
                head.setImageResource(R.mipmap.bee);
                mProfile = R.mipmap.bee;
                profileChange = true;
            }
        });

        CircleImageView im2 = (CircleImageView)(findViewById(R.id.Pro2));
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "You've selected Disk!", Toast.LENGTH_SHORT);
                t.show();
                head.setImageResource(R.mipmap.disk);
                mProfile = R.mipmap.disk;
                profileChange = true;
            }
        });

        CircleImageView im3 = (CircleImageView)(findViewById(R.id.Pro3));
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "You've selected Fat Bee!", Toast.LENGTH_SHORT);
                t.show();
                head.setImageResource(R.mipmap.fatbee);
                mProfile = R.mipmap.fatbee;
                profileChange = true;
            }
        });

        CircleImageView im4 = (CircleImageView)(findViewById(R.id.Pro4));
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "You've selected Ladybug!", Toast.LENGTH_SHORT);
                t.show();
                head.setImageResource(R.mipmap.ladybug);
                mProfile = R.mipmap.ladybug;
                profileChange = true;
            }
        });

        CircleImageView im5 = (CircleImageView)(findViewById(R.id.Pro5));
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "You've selected Spider!", Toast.LENGTH_SHORT);
                t.show();
                head.setImageResource(R.mipmap.spider);
                mProfile = R.mipmap.spider;
                profileChange = true;
            }
        });

        CircleImageView im6 = (CircleImageView)(findViewById(R.id.Pro6));
        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "You've selected Sunflower!", Toast.LENGTH_SHORT);
                t.show();
                head.setImageResource(R.mipmap.sunflower);
                mProfile = R.mipmap.sunflower;
                profileChange = true;
            }
        });

        CircleImageView im7 = (CircleImageView)(findViewById(R.id.Pro7));
        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "You've selected Caterpillar!", Toast.LENGTH_SHORT);
                t.show();
                head.setImageResource(R.mipmap.caterpillar);
                mProfile = R.mipmap.caterpillar;
                profileChange = true;
            }
        });

        CircleImageView im8 = (CircleImageView)(findViewById(R.id.Pro8));
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "You've selected Default Picture!", Toast.LENGTH_SHORT);
                t.show();
                head.setImageResource(R.mipmap.pic);
                mProfile = R.mipmap.pic;
                profileChange = true;
            }
        });



        TextView ip = (TextView)findViewById(R.id.ipAddress);
        ip.setText(getIP(getApplicationContext()));

    }



    @Override
    protected void onStop() {
        save(mUserName,mProfile);
        super.onStop();
    }



    public void save (String username, long profile){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("user", Context.MODE_PRIVATE);
            writer = new BufferedWriter((new OutputStreamWriter(out)));
            writer.write(username);
            writer.newLine();
            writer.write(profile + "");
            Toast t = Toast.makeText(getApplicationContext(), "Your changes have been saved", Toast.LENGTH_SHORT);
            t.show();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            {
                try{
                    if (writer != null){
                        writer.close();
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            in = openFileInput("user");
            reader = new BufferedReader(new InputStreamReader(in));
            storeUName = reader.readLine();
            String profile = reader.readLine();
            if (profile == null){
                storeProfile = R.mipmap.pic;
            } else {
                storeProfile = Long.parseLong(profile);
            }

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

    // Gets IP :)
    public static String getIP(Context c) {
        WifiManager wifiService = (WifiManager) c.getSystemService(WIFI_SERVICE);
        WifiInfo wifiinfo = wifiService.getConnectionInfo();
        return intToIp(wifiinfo.getIpAddress());
    }

    private static String intToIp(int i) {

        return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF)
                + "." + (i >> 24 & 0xFF);
    }

}
