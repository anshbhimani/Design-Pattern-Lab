interface Shape{
	public void draw();
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle is drawn");
	}
	
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle is drawn");
	}
	
}

class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Square is drawn");
	}
	
}

class ShapeMaker{
	private Shape circle = new Circle();
	private Shape rect = new Rectangle();
	private Shape square = new Square();
	private static final ShapeMaker s1 = new ShapeMaker();

	private ShapeMaker(){
		System.out.println("Object Created");
	}

	public static final ShapeMaker getInsantant(){
		return s1;
		
	}
	
	void drawshape(String type){
		if(type.equalsIgnoreCase("circle")){
			circle.draw();
		}
		else if(type.equalsIgnoreCase("rectangle")){
			rect.draw();
		}
		else if(type.equalsIgnoreCase("square")){
			square.draw();
		}
	}
	
}
public class FacadePattern {

	public static void main(String[] args) {
	
		ShapeMaker s1 = ShapeMaker.getInsantant();
		ShapeMaker s2 = ShapeMaker.getInsantant();
		s1.drawshape("circle");
		s1.drawshape("rectangle");
		s1.drawshape("square");
		
	}

}
