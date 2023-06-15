package com.fs.models;


import java.util.List;

public class File {
    private String fileName;
    private float fileSize;

    private List<String> collections;

    public File(String fileName, float fileSize, List<String> collections) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.collections = collections;
    }

    public String getFileName() {
        return fileName;
    }

    public float getFileSize() {
        return fileSize;
    }

    public List<String> getCollections() {
        return collections;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(float fileSize) {
        this.fileSize = fileSize;
    }

    public void setCollections(List<String> collections) {
        this.collections = collections;
    }
}
