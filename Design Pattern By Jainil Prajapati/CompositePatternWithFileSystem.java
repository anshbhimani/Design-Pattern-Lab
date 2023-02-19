import java.util.ArrayList;
import java.util.List;

abstract class FileSystem{
	protected String name = null;
	
	FileSystem(String name){
		this.name = name;
	}
	
	public abstract void showName();
	public abstract int getSize();
	
}

class Files extends FileSystem{
	
	private int size = 0;
	
	Files(String name ,int size){
		super(name);
		setSize(size);
	}

	@Override
	public int getSize(){
		return this.size;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	@Override
	public void showName() {
		System.out.println("\tYour File Name is : "+this.name);
	}
	
}

class Folders extends FileSystem{
	private List<FileSystem> cmp = new ArrayList<FileSystem>();
	Folders(String name) {
		super(name);
	}

	public void addComponent(FileSystem c){
		cmp.add(c);
	}
	
	public void removeComponent(FileSystem c){
		cmp.remove(c);
	}
	
	@Override
	public void showName() {
		System.out.println("Your Folder Name is : "+this.name);
		System.out.println();
		for(FileSystem c : cmp){
			c.showName();
		}
	}

	@Override
	public int getSize() {
		int size = 0;
		for(FileSystem c : cmp){
			size += c.getSize();
		}
		return size;
	}
	
}


public class CompositePatternWithFileSystem {

	public static void main(String[] args) {
		FileSystem file1 = new Files("a.txt",3000);
		FileSystem file2 = new Files("v.pdf",2200);
		FileSystem file3 = new Files("c.docs",500);
		FileSystem file4 = new Files("d.bat",5000);
		FileSystem file5 = new Files("e.exe",3400);
		
		Folders folder = new Folders("MyC ollage Files"); 
		
		folder.addComponent(file1);
		folder.addComponent(file2);
		folder.addComponent(file3);
		folder.addComponent(file4);
		folder.addComponent(file5);
		
		folder.showName();
		
		System.out.println("--------------------------------------------------");
		System.out.println("Your File1 size is: "+file1.getSize());
		System.out.println("Your Total size of folder is: "+folder.getSize());
	}

}
