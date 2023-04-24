import java.util.ArrayList;
import java.util.List;

// Leaf -- File
// Composite -- Directory

abstract class Directory {
    protected String name;
    protected int size;
    protected String type;

    public Directory(String n, int size) {
        name = n;
        this.size = size;
    }

    public Directory(String n, int size, String type) {
        name = n;
        this.size = size;
        this.type = type;
    }

    public abstract void showName();
    public abstract void getSize();
    public abstract void getType();
}

class File extends Directory {
    private int fileSize;
    private String fileName;
    private String fileType;

    public File(String fileName, int fileSize) {
        super(fileName, fileSize);
        this.fileName = fileName;
        this.fileSize = fileSize;
        fileType = null;
    }

    public File(String fileName, int fileSize, String fileType) {
        super(fileName, fileSize, fileType);
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
    }

    @Override
    public void showName() {
        System.out.println("Name of the file is: " + fileName);
    }

    @Override
    public void getSize() {
        System.out.println("Size of the file is: " + fileSize + " bytes.");
    }

    @Override
    public void getType() {
        System.out.println("The type of file is: " + fileType);
    }
}

class Folder extends Directory {
    private List<Directory> directoryList = new ArrayList<Directory>();

    public Folder(String name, int size) {
        super(name, size);
    }

    public void showName() {
        System.out.println("Folder name: " + name);

        for (Directory directory : directoryList) {
            directory.showName();
        }
    }

    public void addDirectory(Directory directory) {
        directoryList.add(directory);
    }

    public void removeDirectory(Directory directory) {
        directoryList.remove(directory);
    }

    public List<Directory> displayDirectories() {
        return directoryList;
    }

    @Override
    public void getSize() {
        int totalSize = 0;
        for (Directory directory : directoryList) {
            totalSize += directory.size;
        }

        System.out.println("Size of the folder is: " + totalSize + " bytes.");
    }

    @Override
    public void getType() {
        System.out.println("This is a folder.");
    }
}

public class Directory_Composite_Design_Pattern 
{
    public static void main(String[] args) {
        Folder javaFolder = new Folder("Java", 0);
        Folder dbmsFolder = new Folder("DBMS", 0);

        File polymorphismFile = new File("Polymorphism", 100);
        File primaryKeyFile = new File("Primary Key", 450, ".csv");

        javaFolder.addDirectory(polymorphismFile);
        dbmsFolder.addDirectory(primaryKeyFile);

        System.out.println("Java Folder");
        javaFolder.showName();
        javaFolder.getSize();
        javaFolder.getType();

        System.out.println("\nDBMS Folder");
        dbmsFolder.showName();
        dbmsFolder.getSize();
        dbmsFolder.getType();

        System.out.println("\nDirectories in DBMS Folder");
        List<Directory> directoryList = dbmsFolder.displayDirectories();
        for (Directory directory : directoryList) {
            directory.showName();
        }
    }
}
