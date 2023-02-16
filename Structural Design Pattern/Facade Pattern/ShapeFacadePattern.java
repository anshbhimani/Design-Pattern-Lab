interface Shape
{
    public void draw();
}

class Rectangle implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Drawing Rectangle !!!");
    }
}

class Circle implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Drawing Circle !!!");
    }
}

class Square implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Drawing Square !!!");
    }
}

class ShapeMaker
{
    private Shape circle1;
    private Shape rectangle1;
    private Shape square1;

    public ShapeMaker()
    {
        circle1 = new Circle();
        square1 = new Square();
        rectangle1 = new Rectangle();
    }

    public void drawCircle()
    {
        circle1.draw();
    }

    public void drawSquare()
    {
        square1.draw();
    }

    public void drawRectangle()
    {
        rectangle1.draw(); 
    }
}

public class ShapeFacadePattern 
{
    public static void main(String[] args) 
    {
        ShapeMaker maker1 = new ShapeMaker();

        maker1.drawCircle();
        maker1.drawRectangle();
        maker1.drawSquare();
    }
}
