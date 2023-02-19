class Home implements Cloneable{
	
	int id = 0;
	String BHK;
	int area;
	double price;
	
	void SetId(int id){
		this.id = id;
	}

	
	@Override
	public Object clone(){
		Object clone = null;
		
		try{
			
			clone = super.clone();
			
		}catch(CloneNotSupportedException ce){
			ce.printStackTrace();
		}
		return clone;
	}
	
	public void setDetails(int id , String BHK , double price , int area){
		this.id = id;
		this.BHK = BHK;
		this.area = area;
		this.price = price;
	}
	
}

class TwoBHKHome extends Home{
	int ParkingCharge;
	
	TwoBHKHome(int id,int ParkingCharge){	
		System.out.println("new Object Created");
		this.ParkingCharge = ParkingCharge; 
		setDetails(id,"2 BHK" , 1200000 , 120);
		
	}
	
	public void GetDetails(){
		System.out.println("Your Home ID is: "+this.id);
		System.out.println("-------------------------------------------------");
		System.out.println("Your Home is: "+this.BHK);
		System.out.println("Your Home area is: "+this.area);
		System.out.println("Your "+this.BHK+" Home parking charge is: "+this.ParkingCharge);
		System.out.println("Your "+this.BHK+" Home price is: "+this.price);
		System.out.println();
		System.out.println();
	}
	
	
}

class ThreeBHKHome extends Home{
	int FurnitureCharge;
	
	ThreeBHKHome(int id,int FurnitureCharge){
		System.out.println("new Object Created");
		this.FurnitureCharge = FurnitureCharge; 
		setDetails(id,"3 BHK" , 2300000 , 200);
	}
	
	public void GetDetails(){
		System.out.println("Your Home ID is: "+this.id);
		System.out.println("-------------------------------------------------");
		System.out.println("Your Home is: "+this.BHK);
		System.out.println("Your Home area is: "+this.area);
		System.out.println("Your "+this.BHK+" Home furniture charge is: "+this.FurnitureCharge);
		System.out.println("Your "+this.BHK+" Home price is: "+this.price);
		System.out.println();
		System.out.println();
	}
	
	
}

public class PrototypePatternWithShallowCopy {

	public static void main(String ars[]){
		TwoBHKHome home1 = new TwoBHKHome(3452,1300);
		ThreeBHKHome home2 = new ThreeBHKHome(25432,130000);
		ThreeBHKHome home3 = (ThreeBHKHome) home2.clone();
		home3.SetId(2354);
		home1.GetDetails();
		home2.GetDetails();
		home3.GetDetails();
	}
	
}
