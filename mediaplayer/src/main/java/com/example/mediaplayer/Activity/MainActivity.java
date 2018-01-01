package com.example.mediaplayer.Activity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mediaplayer.Adapter.MyAdapter;
import com.example.mediaplayer.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener,
        View.OnFocusChangeListener,
        AdapterView.OnItemSelectedListener,
        MediaPlayer.OnPreparedListener
{
    private ListView mLvMusic;
    private List<String> mlist;
    private MyAdapter mAdapter;
    private AssetManager mASMgr;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initWidget();
        setListener();
    }

    private void initWidget()
    {
        mLvMusic = findViewById(R.id.lv_music);
        mAdapter = new MyAdapter(mlist,this);
        mLvMusic.setAdapter(mAdapter);
        mASMgr = this.getAssets();
        mPlayer = new MediaPlayer();
    }

    private void initData()
    {
        String[] musicArray = {"amic.mp3","jppan.mp3","sdar.mp3"};
        mlist = Arrays.asList(musicArray);
    }

    private void setListener()
    {
        mLvMusic.setOnItemClickListener(this);
        mLvMusic.setOnFocusChangeListener(this);
        mLvMusic.setOnItemSelectedListener(this);
        mLvMusic.setOnItemSelectedListener(this);
        stePlayerListener();
    }

    private void stePlayerListener()
    {
        if (null != mPlayer)
        {
            mPlayer.setLooping(true);
            mPlayer.setOnPreparedListener(this);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        playMusic(mlist.get(position));
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        if (null != mPlayer)
        {
            mPlayer.stop();
            mPlayer.reset();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        playMusic(mlist.get(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    private void playMusic(String music)
    {
        try
        {
            mPlayer.reset();
//            mPlayer.setDataSource(mASMgr.openFd(music));
            AssetFileDescriptor afd = mASMgr.openFd(music);
            mPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mPlayer.prepareAsync();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
    }


    @Override
    public void onPrepared(MediaPlayer mp)
    {
        if (!mp.isPlaying())
        {
            mp.start();
        }
    }

    @Override
    protected void onDestroy()
    {
        if (null != mPlayer)
        {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
        super.onDestroy();
    }
}
