package com.example.administrator.hive.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.example.administrator.hive.R;

/**
 * Created by Administrator on 2016/7/21.
 */
public class otherClientsLayout extends CoordinatorLayout{

    public otherClientsLayout(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.other_clients, this);
    }
}
