package filesystem;

public interface FileSystem {
    void ls();
    void delete();
    String getName();
    int getSize();
}