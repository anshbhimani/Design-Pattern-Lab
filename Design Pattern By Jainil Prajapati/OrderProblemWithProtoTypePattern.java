import java.util.ArrayList;

class Order{
	private int ordId;
	private long amount;
	private Address ad;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	Order(int ordId,Address a,Item items[]){
		this.ordId = ordId;
		this.ad = a;
		SetItems(items);
	}
	
	void SetItems(Item it[]){
		int amt = 0;
		
		for(int i = 0 ; i < it.length; i++){
			amt += it[i].getPrice();
			this.items.add(it[i]);
		}
		
		this.amount = amt;
	}
	
	
	void getDetails(){
		System.out.println();
		System.out.println("Your Order ID is: "+this.ordId);
		System.out.println("--------------------------------------------");
		System.out.println("Your Order city is: "+this.ad.getCity());
		System.out.println("Your Order state is: "+this.ad.getState());
		System.out.println();
		for(int i = 0 ; i < this.items.size() ; i++){			
			System.out.println("Your Item "+ (i+1) +") name is :"+ this.items.get(i).getName() + " And price is: "+this.items.get(i).getPrice());
		}
		System.out.println("--------------------------------------------");
		System.out.println("Your Total Amount is: "+this.amount);
		System.out.println();
		System.out.println();
	}
}

class Item{
	private int id;
	private String name;
	private int price;
	
	Item(int id,String name,int price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	int getPrice(){
		return this.price;
	}
	
	String getName(){
		return this.name;
	}

}

class Address {
	private String city;
	private String state;
	
	Address(String city,String state)
	{
		this.city = city;
		this.state = state;
	}
	
	String getCity(){
		return this.city;
	}
	
	String getState(){
		return this.state;	
	}
}

public class OrderProblemWithProtoTypePattern {

	public static void main(String args[]){
		Address a = new Address("Gandhinagar","Gujarat");
		
		Item items[] = {
				new Item(1,"Mobile",2000),
				new Item(2,"Laptop",34000),
				new Item(3,"Fredg",18000),
				new Item(4,"TV",9000),
				new Item(5,"Washing Machiene",12000),
		};
		
		Order o1 = new Order(3445,a,items);
		o1.getDetails();
	}
	
}
