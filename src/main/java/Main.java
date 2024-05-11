import controller.FileSystemController;
import filesystem.Directory;
import filesystem.File;
import filesystem.FileSystem;

import java.util.List;


//Implements file system using composite design pattern

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        FileSystemController fileSystemController = new FileSystemController(root);

        //Create Movies in root directory
        Directory movies = new Directory("Movies");
        fileSystemController.addToDirectory(movies);

        //move to movies directory
        fileSystemController.moveToDirectory(movies);

        Directory action = new Directory("Action Movies");
        fileSystemController.addToDirectory(action);

        Directory comedy = new Directory("Comedy Movies");
        fileSystemController.addToDirectory(comedy);

        File movie1 = new File("RomCom1", 1024, "mp4");
        fileSystemController.addToDirectory(movie1);

        //move to action directory
        fileSystemController.moveToDirectory(action);

        File movie2 = new File("Most Wanted", 2048, "mkv");
        fileSystemController.addToDirectory(movie2);

        File movie3 = new File("War", 3072, "avi");
        fileSystemController.addToDirectory(movie3);

        //move back to Movies directory
        fileSystemController.moveBack();

        //move to Comedy directory
        fileSystemController.moveToDirectory(comedy);

        File movie4 = new File("Hera Pheri", 4096, "mp4");
        fileSystemController.addToDirectory(movie4);

        File movie5 = new File("Hangover", 5120, "mkv");
        fileSystemController.addToDirectory(movie5);

        //move back to root
        fileSystemController.moveBack();
        fileSystemController.moveBack();
        fileSystemController.moveBack();


        // Testing operations

        //Listing all files
        System.out.println("Listing directory:");
        fileSystemController.listCurrentDirectory();

        //get total size
        System.out.println("\nTotal size of Movies directory: " + fileSystemController.getSize()+ " bytes");

        //searching file
        System.out.println("\nSearching for file 'Hangover':");
        FileSystem file = fileSystemController.searchFile("Hangover");
        if (file != null) {
            System.out.println("Found: ");
            file.ls();
        } else {
            System.out.println("File not found");
        }

        //Delete files
        System.out.println("\nDeleting 'Most Wanted' file:");
        fileSystemController.deleteFile("Most Wanted");

        //Listing all files
        fileSystemController.listCurrentDirectory();

        //Deleting Directory
        System.out.println("\nDeleting 'Comedy Movies' directory:");
        fileSystemController.deleteFile("Comedy Movies");

        //Listing all files
        fileSystemController.listCurrentDirectory();
    }
}
