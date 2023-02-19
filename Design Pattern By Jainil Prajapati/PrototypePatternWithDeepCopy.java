class Falt implements Cloneable{
	
	Owner person = null;
	int id = 0;
	String BHK;
	int area;
	double price;
	
	void SetId(int id){
		this.id = id;
	}

	void SetOwner(long mobileno , String name){
		this.person.name = name;
		this.person.mobileno = mobileno;
	}
	
	@Override
	public Object clone(){
		Object clone = null;
		
		try{
			
			clone = super.clone();
			Owner person1 = new Owner(this.person.name,this.person.mobileno);
			this.person = person1;
			
		}catch(CloneNotSupportedException ce){
			ce.printStackTrace();
		}
		return clone;
	}
	
	public void setDetails(int id , String BHK , double price , int area , Owner p1){
		person = p1;
		this.id = id;
		this.BHK = BHK;
		this.area = area;
		this.price = price;
	}
	
}

class Owner{
	String name;
	long mobileno;
	
	Owner(String name, long mobileno){
		this.name = name;
		this.mobileno = mobileno;
	}
}

class TwoBHK extends Falt{
	int ParkingCharge;
	
	TwoBHK(int id,int ParkingCharge,Owner p1){
		this.ParkingCharge = ParkingCharge; 
		setDetails(id,"2 BHK" , 1200000 , 120,p1);
		
	}
	
	public void GetDetails(){
		System.out.println("Your Home ID is: "+this.id);
		System.out.println("-------------------------------------------------");
		System.out.println("Owner Name is: "+this.person.name);
		System.out.println("Owner Mobile No is: "+this.person.mobileno);
		System.out.println("Your Home is: "+this.BHK);
		System.out.println("Your Home area is: "+this.area);
		System.out.println("Your "+this.BHK+" Home parking charge is: "+this.ParkingCharge);
		System.out.println("Your "+this.BHK+" Home price is: "+this.price);
		System.out.println();
		System.out.println();
	}
	
	
}

class ThreeBHK extends Falt{
	int FurnitureCharge;
	
	ThreeBHK(int id,int FurnitureCharge,Owner p1){
		this.FurnitureCharge = FurnitureCharge; 
		setDetails(id,"3 BHK" , 2300000 , 200,p1);
	}
	
	public void GetDetails(){
		System.out.println("Your Home ID is: "+this.id);
		System.out.println("-------------------------------------------------");
		System.out.println("Owner Name is: "+this.person.name);
		System.out.println("Owner Mobile No is: "+this.person.mobileno);
		System.out.println("Your Home is: "+this.BHK);
		System.out.println("Your Home area is: "+this.area);
		System.out.println("Your "+this.BHK+" Home furniture charge is: "+this.FurnitureCharge);
		System.out.println("Your "+this.BHK+" Home price is: "+this.price);
		System.out.println();
		System.out.println();
	}
	
	
}

public class PrototypePatternWithDeepCopy {

	public static void main(String ars[]){
		
		TwoBHK home1 = new TwoBHK(3452,1300,new Owner("Jainil Prajapati",6356297945l));
		ThreeBHK home2 = new ThreeBHK(25432,130000,new Owner("Kishan Rathod",9327024432l));
		ThreeBHK home3 = (ThreeBHK) home2.clone();
		
		home3.GetDetails();
		home3.SetId(64334);
		home3.SetOwner(945865464l, "Dhruv Raval");
		
		home1.GetDetails();
		home2.GetDetails();
		home3.GetDetails();
	}
	
}
