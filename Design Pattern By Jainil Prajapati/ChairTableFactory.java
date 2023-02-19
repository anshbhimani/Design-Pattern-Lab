interface Factory{
	public Factory CreateChair();
	public Factory CreateTable();
}

class Plastic implements Factory{

	public Plastic CreatePlasticProduct(String product){
		switch(product){
			case "Chair":{
				return (Plastic) CreateChair();
			}
			case "Table":{
				return (Plastic) CreateTable();
			}
			default:{
				return null;
			}
		}
	}

	@Override
	public Factory CreateChair() {
		return new PlasticChair();
	}

	@Override
	public Factory CreateTable() {
		return new PlasticTable();
	}
	
}

class Wooden implements Factory{

	public Wooden CreateWoodenProduct(String product){
		switch(product){
		case "Chair":{
			return (Wooden) CreateChair();
		}
		case "Table":{
			return  (Wooden) CreateTable();
		}
		default:{
			return null;
		}
	}
		
	}


	@Override
	public Factory CreateChair() {
		return new WoodenChair();
	}

	@Override
	public Factory CreateTable() {
		return new WoodenChair();
	}
	
	
}


interface Chair{ 
	public void Features();
}

interface Table{
	public void Features();
}

class WoodenChair extends Wooden implements Chair{

	WoodenChair(){
		System.out.println("Wooden chair created");
	}
	
	@Override
	public void Features() {
		
	}
	
}

class PlasticChair extends Plastic implements Chair{

	PlasticChair(){
		System.out.println("plastic chair created");
	}

	@Override
	public void Features() {
		
	}
	
	
}

class WoodenTable extends Wooden implements Table{

	WoodenTable(){
		System.out.println("Wooden table created");
	}

	@Override
	public void Features() {
		
	}
	
}

class PlasticTable extends Plastic implements Table{

	PlasticTable(){
		System.out.println("plastic table created");
	}

	@Override
	public void Features() {
		
	}
	
}

public class ChairTableFactory {
	public static void main(String arg[]){
		Plastic ps = new Plastic();
		Wooden wd = new Wooden();
		
		ps.CreatePlasticProduct("Chair");
		wd.CreateWoodenProduct("Table");
	}
}
