import com.fs.dto.FileCollectionDto;
import com.fs.models.File;
import com.fs.ops.FileOperations;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static void displayFileCollections(List<FileCollectionDto> fileCollections) {
        for(FileCollectionDto collection: fileCollections) {
            System.out.println(collection.getCollectionName() +
                    " ---- " +
                    collection.getCollectionSize() + " MB");
        }
    }
    public static void main(String[] args) {
        FileOperations fOps = new FileOperations();
        fOps.addFile(new File("f1", 100.1F, Arrays.asList("c1")));
        fOps.addFile(new File("f2", 210.32F, Arrays.asList("c2")));
        fOps.addFile(new File("f3", 300.1F, Arrays.asList("c1")));
        fOps.addFile(new File("f4", 50.58F, Arrays.asList("c3")));
        fOps.addFile(new File("f5", 30.32F, Arrays.asList("c4")));
        fOps.addFile(new File("f6", 100.90F, Arrays.asList("c5")));
        fOps.addFile(new File("f7", 250.80F, Arrays.asList("c2")));

        System.out.println("Total File Size= "+ fOps.getProcessedFileSize() + " MB");
        System.out.println("Total 2 collections:");
        displayFileCollections(fOps.getTopKCollectionsBySize(2));
        System.out.println("Total 3 collections:");
        displayFileCollections(fOps.getTopKCollectionsBySize(3));
    }
}