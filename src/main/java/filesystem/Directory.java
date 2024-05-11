package filesystem;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Directory implements FileSystem {
    private final String directoryName;
    private List<FileSystem> fileSystemList;

    public Directory(String directoryName){
        this.directoryName = directoryName;
        this.fileSystemList = new ArrayList<>();
    }

    public void addToList(FileSystem fileSystem){
        this.fileSystemList.add(fileSystem);
    }
    @Override
    public void ls() {
        System.out.println("Directory Name is " + directoryName);
        for(FileSystem fileSystem : fileSystemList) {
            fileSystem.ls();
        }
    }

    @Override
    public void delete() {
        System.out.println("Deleting directory: " + directoryName);
    }

    public boolean deleteFile(String fileNameToBeDeleted) {
        for (FileSystem file : fileSystemList) {
            if (file instanceof File && file.getName().equals(fileNameToBeDeleted)) {
                file.delete();
                fileSystemList.remove(file);
                return true;
            } else if (file instanceof Directory) {
                if(file.getName().equals(fileNameToBeDeleted)){
                    file.delete();
                    fileSystemList.remove(file);
                    return true;
                }
                if (((Directory) file).deleteFile(fileNameToBeDeleted)) {
                    return true;
                }
            }
        }
        return false;
    }


    public FileSystem searchFile(String fileName) {
        for (FileSystem file : fileSystemList) {
            if (file instanceof File && file.getName().equals(fileName)) {
                return file;
            } else if (file instanceof Directory) {
                FileSystem foundFile = ((Directory) file).searchFile(fileName);
                if (foundFile != null) {
                    return foundFile;
                }
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return directoryName;
    }

    public int getSize(){
        int totalSize = 0;
        for(FileSystem file : fileSystemList){
            if(file instanceof File)
                totalSize += file.getSize();
            totalSize += file.getSize();
        }
        return totalSize;
    }


//    public boolean checkDirectoryContainsFile(FileSystem file){
//        for(FileSystem fileSystem : fileSystemList){
//            if(fileSystem instanceof File)
//        }
//    }
}