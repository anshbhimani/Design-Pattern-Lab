interface Chair
{
    public abstract void designChair();    
}

interface Table
{
    public abstract void designTable();
}

class Wooden_Chair implements Chair
{
    @Override
    public void designChair()
    {
        System.out.println("Designing Wooden Chair !!");
    }
}

class Plastic_Chair implements Chair
{
    @Override
    public void designChair() 
    {
        System.out.println("Designing Plastic Chair !!");
    }
}

class Wooden_Table implements Table
{
    @Override
    public void designTable()
    {
        System.out.println("Designing Wooden Table !!");
    }
}

class Plastic_Table implements Table
{
    @Override
    public void designTable() 
    {
        System.out.println("Designing Plastic Table !!");    
    }
}

interface Furniture_Factory
{
    public abstract Chair createChair(String material);
    public abstract Table createTable(String material);
}

class Wooden_Factory implements Furniture_Factory
{
    //return object
    @Override
    public Chair createChair(String material)
    {
        if(material == "Wooden")
        {
            return new Wooden_Chair();
        }
        
        else
        {
            return null;
        }
    }

    @Override
    public Table createTable(String material)
    {
        if(material == "Wooden")
        {
            return new Wooden_Table();
        }
        
        else
        {
            return null;
        }
    }
}

class Plastic_Factory implements Furniture_Factory
{
    @Override
    public Chair createChair(String material)
    {
        if(material == "Plastic")
        {
            return new Plastic_Chair();
        }
        
        else
        {
            return null;
        }
    }

    @Override
    public Table createTable(String material)
    {
        if(material == "Plastic")
        {
            return new Plastic_Table();
        }
        
        else
        {
            return null;
        }
    }
}

class Factory
{
    public Furniture_Factory createFurniture(String Furniture_Type)
    {
        if(Furniture_Type == "Wooden")
        {
            return new Wooden_Factory();
        }

        else if(Furniture_Type == "Plastic")
        {
            return new Plastic_Factory();
        }

        else
        {
            return null;
        }
    }
}


public class FurnitureTest 
{
    public static void main(String[] args) 
    {
        Furniture_Factory w1 = new Wooden_Factory();
        Furniture_Factory p1 = new Plastic_Factory();
        
        Chair c1,c2;
        Table t1,t2;

        c1 = w1.createChair("Wooden");
        c2 = p1.createChair("Plastic");

        t1 = w1.createTable("Wooden");
        t2 = p1.createTable("Plastic");

        c1.designChair();
        c2.designChair();

        System.out.println(" ");
        
        t1.designTable();
        t2.designTable();
    }
}
