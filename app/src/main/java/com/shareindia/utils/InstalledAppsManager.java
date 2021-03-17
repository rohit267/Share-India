package com.shareindia.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.shareindia.Models.AppModel;

import java.util.ArrayList;
import java.util.List;

public class InstalledAppsManager {
    private Context context;

    public InstalledAppsManager(Context context){
        this.context=context;
    }

    public List<AppModel> getAllInstalledApplications() {
        @SuppressLint("WrongConstant") List<ApplicationInfo> installedApps = context.getPackageManager().getInstalledApplications(PackageManager.PERMISSION_GRANTED);
        //List<ApplicationInfo> sysApps = context.getPackageManager().getInstalledApplications(PackageManager.MATCH_SYSTEM_ONLY);
        List<AppModel> launchableInstalledApps = new ArrayList<>();

        for(int i =0; i<installedApps.size(); i++){
            if(context.getPackageManager().getLaunchIntentForPackage(installedApps.get(i).packageName) != null){
                AppModel appModel= new AppModel();
                ApplicationInfo applicationInfo = installedApps.get(i);
                String packageName =applicationInfo.packageName;
                String applicationName = getAppName(applicationInfo,packageName);
                String srcLocation = applicationInfo.sourceDir;
                appModel.setSrcLocation(srcLocation);
                appModel.setAppName(applicationName);
                appModel.setPackageName(packageName);
                launchableInstalledApps.add(appModel);
            }
        }


        return launchableInstalledApps;
    }

    private String getAppName(ApplicationInfo applicationInfo,String packageName){
        final PackageManager pm = context.getPackageManager();
        try {
            applicationInfo = pm.getApplicationInfo( packageName, 0);
        } catch (final PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        final String applicationName = (String) (applicationInfo != null ? pm.getApplicationLabel(applicationInfo) : "(unknown)");
        return applicationName;
    }

}
