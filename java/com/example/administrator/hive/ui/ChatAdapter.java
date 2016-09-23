package com.example.administrator.hive.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.hive.R;

import java.security.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import messaging.messages;

/**
 * Created by Administrator on 2016/9/2.
 */
public class ChatAdapter extends ArrayAdapter<messages>{
    private final Context context;
    private LayoutInflater inflater;
    private List<messages> values;

    public ChatAdapter(Context context, List<messages> values){
        super(context, R.layout.chat_layout_box,android.R.id.text1, values);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.values = values;
    }

    class ViewHolder {
        TextView userNameClient;
        TextView message_content;
        TextView timeStamp;
        messages msg;
        View userPresence;
    }

    @Override
    public View getView (final int position, View convertView, ViewGroup parent){
        messages msg = this.values.get(position);
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.chat_layout_box, parent, false);
            holder.userNameClient = (TextView)convertView.findViewById(R.id.userNameClient);
            holder.message_content = (TextView)convertView.findViewById(R.id.content);
            holder.timeStamp = (TextView)convertView.findViewById(R.id.time);
            ///holder.userpresence and stuff
            ///Fine it !!! in ChatAdapter Class!!!
        } else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.userNameClient.setText(msg.getUsername());
        holder.timeStamp.setText(getTimeString(msg.getTime()));
        holder.message_content.setText( msg.getText());
        holder.msg = msg;
        return convertView;
    }

    @Override
    public int getCount(){
        return this.values.size();
    }

    // A new message added
    public void addMsg (messages msg){
        this.values.add(msg);
        notifyDataSetChanged();
    }

    // New messages added from a new user
    public void newIncomeMsg(List<messages> newValues){
        this.values.addAll(newValues);
        notifyDataSetChanged();
    }

    // Clear all messages
    public void clearMsg (){
        this.values.clear();
        notifyDataSetChanged();
    }

    public String getTimeString(String time){
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = sdf.format(Long.parseLong(time + "000"));
        return date;
    }

}
