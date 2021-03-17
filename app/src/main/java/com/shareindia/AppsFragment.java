package com.shareindia;

import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.shareindia.Models.AppModel;
import com.shareindia.utils.InstalledAppsManager;

import java.util.ArrayList;
import java.util.List;


public class AppsFragment extends Fragment {

    public static View.OnClickListener myOnClickListener;
    private InstalledAppsManager installedAppsManager;
    private List<AppModel> apps;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    FloatingActionButton sendBtn, receiveBtn;
    public AppsFragment() {
        // Required empty public constructor
    }

    public static AppsFragment newInstance(String param1, String param2) {
        AppsFragment fragment = new AppsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        installedAppsManager = new InstalledAppsManager(getContext());

        apps= (List<AppModel>) installedAppsManager.getAllInstalledApplications();

        View v =inflater.inflate(R.layout.fragment_apps, container, false);
        View mainView = inflater.inflate(R.layout.activity_main2,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_list_apps);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter= new AppsListAdapter((ArrayList<AppModel>) apps,getContext());
        recyclerView.setAdapter(adapter);
        sendBtn = mainView.findViewById(R.id.btn_send);
        receiveBtn = mainView.findViewById(R.id.btn_receive);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  // CREATE SERVER

            }
        });

        receiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  // CONNECT TO SERVER

            }
        });


        myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundColor(Color.BLUE);
            }
        };

        return v;
    }
}