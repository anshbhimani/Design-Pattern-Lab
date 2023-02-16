class Address
{
    private String City;
    private String Area;

    public Address(String city, String area)
    {
        City = city;
        Area = area;
    }

    public void setAreaName(String Area) 
    {
        this.Area=Area;
    }

    public String getCity()
    {
        return City;
    }

    public String getAreaName()
    {
        return Area;
    }
}

class Order implements Cloneable
{
    private int orderID;
    private long amount;
    private Address ad;
    
    public Order(int orderID,long amount,Address ad)
    {
        this.orderID = orderID;
        this.amount = amount;
        this.ad = ad;
    }

    public void setAmount(long am) 
    {
        amount = am;    
    }

    public String toString()
    {
        return "Order Id : " + orderID + " and amount is : " + amount + " @ " + ad.getAreaName()+ " " + ad.getCity(); 
    }

    public Order clone()
    {
        Order o1 = null;

        try 
        {
            o1 = (Order) super.clone(); // did casting as by default clone method returns as object type    
        } 
        
        catch (CloneNotSupportedException e) 
        {
            
        }

        return o1;
    }
}


class ShallowCopyExample
{
    public static void main(String[] args) 
    {
        Address a = new Address("Ahmedabad","Nikol");
        Order o1 = new Order(101,2000,a);
        Order o2 = o1.clone();
        
        System.out.println("*** Before Changing the detail in Order ***");
        System.out.println("Original Order : " + o1);
        System.out.println("Cloned Order : " + o2);

        o2.setAmount(3000); // shallow copy
        System.out.println("");
        
        System.out.println("*** After Changing the detail in Order ***");
        System.out.println("Original Order : " + o1);
        System.out.println("Cloned Order : " + o2);
    }
}