package com.example.administrator.hive.ui;

import android.content.Intent;
import android.media.effect.Effect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hive.R;

public class ChangeUsernameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_usr_activity);

        Intent i = getIntent();

        final EditText userName = (EditText)(findViewById(R.id.username_change));
        userName.append(i.getStringExtra("Username"));
        userName.setFreezesText(false);

        TextView Title = (TextView)(findViewById(R.id.main_Title));
        Title.setText("Change your Username");

        ImageView buttonLeft = (ImageView)(findViewById(R.id.buttonLeft));
        buttonLeft.setImageResource(R.mipmap.go_back);
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Settings.class);
                startActivity(i);
                finish();
            }
        });

        ImageView buttonRight = (ImageView)(findViewById(R.id.buttonRight));
        buttonRight.setImageResource(R.mipmap.save);
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Settings.class);
                i.putExtra("Username_Changed",userName.getText().toString());
                i.putExtra("Changed_name",true);
                startActivity(i);
                finish();
            }
        });
    }
}
