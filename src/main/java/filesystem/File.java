package filesystem;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class File implements FileSystem {
    private final String fileName;
    private final int size; // in bytes
    private final LocalDateTime creationDate;
    private final String fileType;
    private final String permissions;

    public File(String fileName, int size, String fileType){
        this.fileName = fileName;
        this.size = size;
        this.creationDate = LocalDateTime.now();
        this.fileType = fileType;
        this.permissions = "rw-r--r--"; // Default permissions
    }

    @Override
    public void ls() {
        System.out.println("File Name: " + this.fileName +
                ", Size: " + this.size +
                ", Creation Date: " + this.creationDate +
                ", File Type: " + this.fileType +
                ", Permissions: " + this.permissions);
    }

    @Override
    public void delete() {
        System.out.println("Deleting file: " + fileName);
    }

    @Override
    public String getName() {
        return fileName;
    }
}