package com.fs.ops;

import com.fs.dto.FileCollectionDto;
import com.fs.models.File;

import java.util.List;

public interface IFileOperations {
    public void addFile(File file);
    public Float getProcessedFileSize();
    public List<FileCollectionDto> getTopKCollectionsBySize(int k);
}