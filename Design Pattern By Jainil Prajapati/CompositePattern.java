import java.util.ArrayList;
import java.util.List;

abstract class Component{
	protected String name = null;
	
	Component(String name){
		this.name = name;
	}
	
	public abstract void showName();
	public abstract int getPrice();
	
}

class Leaf extends Component{
	
	private int price = 0;
	
	Leaf(String name ,int price){
		super(name);
		setPrice(price);
	}

	@Override
	public int getPrice(){
		return this.price;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	@Override
	public void showName() {
		System.out.println("\tYour Product Name is : "+this.name);
	}
	
}

class Composite extends Component{
	private List<Component> cmp = new ArrayList<Component>();
	Composite(String name) {
		super(name);
	}

	public void addComponent(Component c){
		cmp.add(c);
	}
	
	public void removeComponent(Component c){
		cmp.remove(c);
	}
	
	@Override
	public void showName() {
		System.out.println("Your Package Name is : "+this.name);
		System.out.println();
		for(Component c : cmp){
			c.showName();
		}
	}

	@Override
	public int getPrice() {
		int price = 0;
		for(Component c : cmp){
			price += c.getPrice();
		}
		return price;
	}
	
}

public class CompositePattern {
	public static void main(String args[]){
		Component c1 = new Leaf("Car",3000);
		Component c2 = new Leaf("Bike",2200);
		Component c3 = new Leaf("Doll",500);
		Component c4 = new Leaf("Helicopter",5000);
		Component c5 = new Leaf("Plane",3400);
		
		Composite cmps1 = new Composite("Toys"); 
		
		cmps1.addComponent(c1);
		cmps1.addComponent(c2);
		cmps1.addComponent(c3);
		cmps1.addComponent(c4);
		cmps1.addComponent(c5);
		
		cmps1.showName();
		
//		System.out.println("Price of c1 is: "+c1.getPrice());
		System.out.println("Price of Toys is: "+cmps1.getPrice());
	}
}
