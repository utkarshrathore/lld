package com.fs.dto;

public class FileCollectionDto {
    private String collectionName;
    private Float collectionSize;

    public FileCollectionDto(String collectionName, Float collectionSize) {
        this.collectionName = collectionName;
        this.collectionSize = collectionSize;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Float getCollectionSize() {
        return collectionSize;
    }

    public void setCollectionSize(Float collectionSize) {
        this.collectionSize = collectionSize;
    }
}
