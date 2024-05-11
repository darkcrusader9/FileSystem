package controller;

import filesystem.Directory;
import filesystem.File;
import filesystem.FileSystem;
import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

@Setter
@Getter
public class FileSystemController {
    Directory currentDirectory;
    Stack<Directory> directoryStack;
    public FileSystemController(Directory root){
        this.currentDirectory = root;
        this.directoryStack = new Stack<>();
        directoryStack.push(root);
    }

    public String getDirectoryName(){
        return currentDirectory.getName();
    }

    public void listCurrentDirectory() {
        currentDirectory.ls();
    }

    public void deleteFile(String fileName){
        boolean status = currentDirectory.deleteFile(fileName);
        if(status){
            System.out.println("Deleted successfully");
        } else {
            System.out.println("File not found");
        }

    }

    public void addToDirectory(FileSystem file){
        currentDirectory.addToList(file);
    }

    public boolean moveToDirectory(FileSystem fileSystem){
        if(fileSystem instanceof File){
            System.out.println("Cannot move as it is file");
            return false;
        }
        directoryStack.push((Directory) fileSystem);
        currentDirectory = (Directory) fileSystem;
        return true;
    }

    private boolean checkDirectoryWithName(String name) {
        for(FileSystem fileSystem : currentDirectory.getFileSystemList()){
            if(fileSystem.getName().equals(name))
                return true;
        }
        return false;
    }

    public void moveBack(){
        if (!directoryStack.isEmpty()) {
            currentDirectory = directoryStack.pop();
        } else {
            System.out.println("No directory to move back to.");
        }
    }

    public FileSystem searchFile(String fileName) {
        return currentDirectory.searchFile(fileName);
    }

    public int getSize(){
        return currentDirectory.getSize();
    }

}
