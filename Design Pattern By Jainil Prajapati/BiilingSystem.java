import java.util.Random;

interface DiscountableBill{
	int Discount = 10;
}

abstract class Bill{
	private long billid;
	private int bill_unit;
	private int unit_rate;

	Bill(int bill_unit , int unit_rate){
		this.billid = new Random().nextInt(999999999);
		this.bill_unit = bill_unit;
		this.unit_rate = unit_rate;
	}
	
	public float Get(){
		return this.bill_unit*this.unit_rate;
	}
	
	
	abstract public float CalculateBill();
	
	public void PrintBill(){
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		System.out.println("Here is your bill.....");
		System.out.println("Bill Id : "+this.billid);
		System.out.println("Bill Unit : "+this.bill_unit);
		System.out.println("Rate per Unit : "+this.unit_rate);
		System.out.println("Your Total Amount");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Total Amount : "+this.CalculateBill());
		System.out.println();
		System.out.println();
		
	}
}

class MobileBill extends Bill implements DiscountableBill{

	private int ExtraCharges;

	MobileBill(int bill_unit, int unit_rate,int ExtraCharges ) {
		super(bill_unit, unit_rate);
		this.ExtraCharges = ExtraCharges;
	}

	
	@Override
	public float CalculateBill() {
		int result = (int) this.Get() / this.Discount;
		return (result + ExtraCharges);
		
	}
	
}

class ElectricityBill extends Bill{

	private int ExtraCharges;

	ElectricityBill(int bill_unit, int unit_rate,int ExtraCharges) {
		super(bill_unit, unit_rate);
		this.ExtraCharges = ExtraCharges;
	}

	
	@Override
	public float CalculateBill() {
		return this.Get() + ExtraCharges;
	}
	
}

class GasBill extends Bill{

	private int ExtraCharges;

	GasBill(int bill_unit, int unit_rate,int ExtraCharges) {
		super(bill_unit, unit_rate);
		this.ExtraCharges = ExtraCharges;
	}

	
	@Override
	public float CalculateBill() {
		
		return this.Get() + ExtraCharges;
	}
	
}

public class BiilingSystem {

	public static void main(String[] args){
		MobileBill mobile = new MobileBill(43,5,120);
		ElectricityBill electricity = new ElectricityBill(213,43,134);
		GasBill gas = new GasBill(451,53,231);
		
		mobile.CalculateBill();
		electricity.CalculateBill();
		gas.CalculateBill();
		
		System.out.println("Mobile Bill....");
		mobile.PrintBill();
		
		System.out.println("Electricity Bill....");
		electricity.PrintBill();
		
		System.out.println("Gas Bill....");
		gas.PrintBill();
	}
	
}
