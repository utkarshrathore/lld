package com.fs.ops;

import com.fs.dto.FileCollectionDto;
import com.fs.models.File;

import java.util.*;

public class FileOperations implements IFileOperations {
    private Float totalFileSize;
    private Map<String, Float> fileCollectionToSizeMap;

    private List<File> files;

    public FileOperations() {
        totalFileSize = 0F;
        fileCollectionToSizeMap = new HashMap();
        files = new LinkedList();
    }

    @Override
    public void addFile(File file) {
        files.add(file);
        totalFileSize+=file.getFileSize();
        List<String> fileCollections = file.getCollections();
        for(String fileCollection: fileCollections) {
                fileCollectionToSizeMap.put(
                        fileCollection,
                        fileCollectionToSizeMap.getOrDefault(fileCollection, 0F)+
                                file.getFileSize()
                );
        }
    }
    @Override
    public Float getProcessedFileSize() {
        return this.totalFileSize;
    }

    @Override
    public List<FileCollectionDto> getTopKCollectionsBySize(int k) {
        PriorityQueue<FileCollectionDto> minHeap = new PriorityQueue<FileCollectionDto>(
                (fc1, fc2) -> (fc1.getCollectionSize()- fc2.getCollectionSize())>=0?1:-1);
        List<FileCollectionDto> topK = new LinkedList();

        Iterator it = fileCollectionToSizeMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry val = (Map.Entry) it.next();
            minHeap.add(new FileCollectionDto((String) val.getKey(), (Float)val.getValue()));
            if(minHeap.size()>k) {
                minHeap.poll();
            }
        }

        while (minHeap.size()>0) {
            topK.add(minHeap.poll());
        }

        /**
         * It's a min heap so we are getting minimum element first.
         * Reverse the order so that we get collections in descending order.
         */

        Collections.reverse(topK);
        return topK;
    }
}
