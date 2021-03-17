package com.shareindia;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.shareindia.Models.SendFileModel;
import com.shareindia.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    public List<SendFileModel> fileSendList;
    FloatingActionButton sendBtn,recBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        fileSendList = new ArrayList<>();

        sendBtn = findViewById(R.id.btn_send);
        recBtn = findViewById(R.id.btn_receive);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fileSendList.size()>0){
                    for(int i=0;i<fileSendList.size();i++){
                        Log.i("FileName",""+fileSendList.get(i).getFileName());
                        Log.i("FileType",""+fileSendList.get(i).getFileType());
                        Log.i("FileDir",""+fileSendList.get(i).getFileSrc());
                    }
                }
                else{
                    Snackbar.make(findViewById(android.R.id.content),"Please select some files",Snackbar.LENGTH_SHORT).show();
                }

            }
        });

        recBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}