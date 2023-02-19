class CreateSamsung implements Mobile{

	public String Osname;
	private int price;
	
	CreateSamsung(String os,int price){
		Osname = os;
		this.price = price; 
	}

	@Override
	public void OSName() {
		System.out.println("Os Name is: "+this.Osname);
	}

	@Override
	public void PlayMusic() {
		System.out.println("Playing Music");
	}

	@Override
	public void SendMessage() {
		System.out.println("Sending Message");
	}
}

class CreateApple implements Mobile{
	public String Osname;
	private int price;
	
	CreateApple(String os,int price){
		Osname = os;
		this.price = price; 
	}

	@Override
	public void OSName() {
		System.out.println("Os Name is: "+this.Osname);
	}

	@Override
	public void PlayMusic() {
		System.out.println("Playing Music");
	}

	@Override
	public void SendMessage() {
		System.out.println("Sending Message");
	}

}

class CreateNokia implements Mobile{
	public String Osname;
	private int price;
	
	CreateNokia(String os,int price){
		Osname = os;
		this.price = price; 
	}

	@Override
	public void OSName() {
		System.out.println("Os Name is: "+this.Osname);
	}

	@Override
	public void PlayMusic() {
		System.out.println("Playing Music");
	}

	@Override
	public void SendMessage() {
		System.out.println("Sending Message");
	}

}

class MobileFactory{
	public  Mobile CreateMobile(String os){
		switch(os)
		{
			case "Android":{
				return new CreateSamsung("Android",24000);
			}
			case "Ios":{
				return new CreateApple("Ios",70000);
			}
			case "Windows":{
				return new CreateNokia("Windows",10000);
			}
			default:{				
				return null;
			}
		}
		
	}
}

interface Mobile{
	public void OSName();
	public void PlayMusic();
	public void SendMessage();
	
}



public class Mobiles {

	public static void main(String args[]){
		
		MobileFactory m1 = new MobileFactory();
		
		Mobile m2 = m1.CreateMobile("Android");
		Mobile m3 = m1.CreateMobile("Ios");
		
		m2.OSName();
		m3.OSName();
		
	}
	
}
