package com.shareindia.Models;

import androidx.annotation.NonNull;

public class SendFileModel {
    private String fileName=null;
    private String fileType=null;
    private String fileSrc=null;

    public SendFileModel() {

    }

    public SendFileModel(String fileName, String fileType, String fileSrc) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSrc = fileSrc;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSrc() {
        return fileSrc;
    }

    public void setFileSrc(String fileSrc) {
        this.fileSrc = fileSrc;
    }

    @NonNull
    @Override
    public String toString() {
        return getFileName()+","+getFileType()+","+getFileSrc();
    }
}
