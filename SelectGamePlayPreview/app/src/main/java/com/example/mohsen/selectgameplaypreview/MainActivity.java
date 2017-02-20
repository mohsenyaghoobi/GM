package com.example.mohsen.selectgameplaypreview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    VideoView videov;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.listview);
        String[] values = new String[]{"AudioSurf", "Mario"};

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        videov = (VideoView) findViewById(R.id.videoView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent vIntent = new Intent(Intent.ACTION_VIEW);
                    String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.aaa;
                    Uri uri = Uri.parse(videoPath);
                    videov.setVideoURI(uri);
                    videov.start();
                } else if (position == 1) {
                    Intent vIntent = new Intent(Intent.ACTION_VIEW);
                    String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.bbb;
                    Uri uri = Uri.parse(videoPath);
                    videov.setVideoURI(uri);
                    videov.start();
                }
            }
        });
    }
}

