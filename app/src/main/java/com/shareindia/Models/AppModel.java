package com.shareindia.Models;

public class AppModel {
    private boolean isSelected = false;
    private String packageName=null;
    private String appName=null;
    private String srcLocation=null;

    public AppModel(){

    }

    AppModel(String packageName,String appName,String srcLocation){
        this.packageName=packageName;
        this.appName=appName;
        this.srcLocation=srcLocation;
    }


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSrcLocation() {
        return srcLocation;
    }

    public void setSrcLocation(String srcLocation) {
        this.srcLocation = srcLocation;
    }

    public String getFileType(){
        return "apk";
    }



    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }
}
