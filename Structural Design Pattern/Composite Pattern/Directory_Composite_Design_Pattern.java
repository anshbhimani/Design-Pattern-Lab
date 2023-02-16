import java.util.ArrayList;
import java.util.List;

// leaf -- file
// Composite -- directory

abstract class Directory
{
    protected String name;
    protected int size;
    protected String type;
    
    public Directory(String n, int size)
    {
        name = n;
        this.size=size;
    }

    public Directory(String n, int size, String type)
    {
        name=n;
        this.size=size;
        this.type=type;
    }

    public abstract void showname();
    public abstract void getSize();
    public abstract void getType();
}

class Files extends Directory
{
    private int file_size;
    private String file_name;
    private String file_type;

    public Files(String file_name, int file_size)
    {
        super(file_name,file_size);
        file_type = null;
    }

    public Files(String file_name, int file_size, String file_type)
    {
        super(file_name,file_size,file_type);
    }

    @Override
    public void showname()
    {
        System.out.println("Name of the file is : " + file_name);
    }

    @Override
    public void getSize()
    {
        System.out.println("Size of the file is : " + file_size);
    
    }

    @Override
    public void getType()
    {
        System.out.println("The type of file is : " + file_type);
    }

}

class Folders extends Directory
{
    private List<Directory> list = new ArrayList<Directory>();
    

    public Folders(String name,int size)
    {
        super(name,size);
    }

    public void showname()
    {
        System.out.println("Folders name : " + name);

        for(Directory d : list)
        {
            d.showname();
        }
    }

    public void addFolder(Directory d)
    {
        list.add(d);
    }

    public void deleteFolder(Directory d)
    {
        list.remove(d);
    }

    public List displayDirectory()
    {
        return list;
    }

    int total_size;

    @Override
    public void getSize()
    {
        for(Directory d : list)
        {
            total_size = size + total_size;
        }

        System.out.println("Size is : " + total_size); 
    }

    @Override
    public void getType()
    {
        System.out.println("This is a Folder");
    }
}

public class Directory_Composite_Design_Pattern
{
    public static void main(String[] args) 
    {
        Directory d1 = new Folders("Java", 20);
        Directory d2 = new Folders("DBMS", 100);
        
        Directory d3 = new Files("Polymorphism", 100);
        Directory d4 = new Files("Primary Key",450,".csv");

        d2.showname();
        d1.getSize();

        d3.getSize();
        d4.getType();
        d1.getType();
    }
}
