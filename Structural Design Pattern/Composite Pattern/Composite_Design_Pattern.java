import java.util.ArrayList;
import java.util.List;

abstract class Component
{
    protected String name;
    
    public Component(String n)
    {
        name = n;
    }
    public abstract void showname();
    public abstract int getPrice();
}

class Leaf extends Component
{
    private int price;

    public Leaf(String name)
    {
        super(name);
        price = 10000;
    }

    public Leaf(String name, int price)
    {
        super(name);
        this.price=price;
    }

    @Override
    public void showname() 
    {
        System.out.println("Leaf : " + name);
    }

    @Override
    public int getPrice()
    {
        return price;
    }

}

class Composite extends Component
{
    private List<Component> ls = new ArrayList<Component>();

    public Composite(String name) 
    {
        super(name);
    }

    @Override
    public void showname() 
    {
        System.out.println("Composite : " + name);

        for(Component c : ls){
            c.showname();
        }
        
    }

    public void addComponent(Component c)
    {
        ls.add(c);
    }

    public void removeComponent(Component c)
    {
        ls.remove(c);
    }

    public List getComponents(){
        return ls;
    }

    int total;
    public int getPrice()
    {
        for(Component c : ls)
        {
            total = c.getPrice() + total;
        }

        return total;
    }
}

public class Composite_Design_Pattern
{
    public static void main(String[] args) 
    {
        Component l1 = new Leaf("HDD",1000);
        Component l2 = new Leaf("RAM",20000);
        Component l3 = new Leaf("CPU",55000);
        Component l4 = new Leaf("Keyboard",750);
        Component l5 = new Leaf("Mouse",150);

        Composite c1 = new Composite("Computer");
        Composite c2 = new Composite("cabinet");
        Composite c3 = new Composite("Peripharal");
        Composite c4 = new Composite("Mother-board");

        c4.addComponent(l2);
        c4.addComponent(l3);

        c3.addComponent(l4);
        c3.addComponent(l5);

        c2.addComponent(l1);
        c2.addComponent(c4);

        c1.addComponent(c3);
        c1.addComponent(c2);

        l1.showname();

        c4.showname();

        System.out.println(c2.getPrice());
        System.out.println(c3.getPrice());
    }
}