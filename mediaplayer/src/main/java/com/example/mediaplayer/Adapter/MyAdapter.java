package com.example.mediaplayer.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mediaplayer.R;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends BaseAdapter
{
    private List<String> mList = new ArrayList<>() ;
    private Context mContext;
    private final String TAG = MyAdapter.class.getSimpleName();

    public MyAdapter(List<String> list,Context context)
    {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount()
    {
        return mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        MyHolder holder;
        if (null == convertView)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.music_list_item,null);
            holder = new MyHolder(convertView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (MyHolder) convertView.getTag();
        }
        String str = mList.get(position);
        Log.i( TAG, "getView: " + str);
        holder.mtv_music.setText(str);

        return convertView;
    }

    private class MyHolder
    {
        TextView mtv_music;
        MyHolder(View v)
        {
            mtv_music = v.findViewById(R.id.tv_music);
        }
    }


}
