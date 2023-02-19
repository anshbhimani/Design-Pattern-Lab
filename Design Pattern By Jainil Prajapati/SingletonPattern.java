class Singleton{ 
	private int amount = 0;
	private String name = null; 
	private static final Singleton s1 = new Singleton();
	
	private Singleton(){
		System.out.println("New Object is Created");
	}
	
	public static Singleton getInstance(String name ,int amount){
		if(s1.name == null && s1.amount == 0){			
			s1.amount = amount;
			s1.name = name;
		}
		return s1;
	}
	
	public static String getValue(){
		return s1.name;
	}
	
	public Singleton OpenAccount(){
		
		return this;
	}
	
	
	
}


public class SingletonPattern {
	
	public static void main(String args[]){
		Singleton s1 = Singleton.getInstance("jainil", 23412);
		Singleton s2 = Singleton.getInstance("Kishan", 64525);
		
		System.out.println(s1.OpenAccount().getValue());	
		System.out.println(s2.OpenAccount().getValue());
		
	}
	
}
