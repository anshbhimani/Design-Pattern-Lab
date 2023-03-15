import java.lang.*;
import java.util.HashMap;
import java.util.Map;

class Owner
{
    private String OwnerName;
    private String OwnerCity;
    
    public String getOwnerName() 
    {
        return OwnerName;
    }
    public String getOwnerCity() 
    {
        return OwnerCity;
    }

    public void setOwnerCity(String ownerCity) 
    {
        OwnerCity = ownerCity;
    }

    public void setOwnerName(String ownerName) 
    {
        OwnerName = ownerName;
    }

    public Owner(String on, String oc)
    {
        this.OwnerCity=oc;
        this.OwnerName=on;
    }
}

class House implements Cloneable
{
    private int houseArea;
    private int housePrice;
    private int houseID;
    private Owner od;

    public void setHouseID(int houseIDs) 
    {
        this.houseID = houseIDs;
    }

    public void setHouseArea(int houseArea) 
    {
        this.houseArea = houseArea;
    }

    public void setHousePrice(int housePrice) 
    {
    
        this.housePrice = housePrice;
    }

    House(int ID,int harea,int hprice,Owner o)
    {
        this.houseID=ID;
        this.houseArea=harea;
        this.housePrice=hprice;
        this.od=o;
    }
    
    public void setOd(Owner od) 
    {
        this.od = od;
    }

    public Owner getOd() 
    {
        return od;
    }

    public int getHouseID() 
    {
        return houseID;
    }

    @Override
    public String toString() 
    {
        return "House{" +
        "houseArea=" + houseArea +
        ", housePrice=" + housePrice +
        ", houseID=" + houseID +
        ", ownerName=" + od.getOwnerName() +
        ", ownerCity="+od.getOwnerCity()+
        '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        House h1=null;
        h1=(House)super.clone();
        Owner o1=new
        Owner(this.od.getOwnerName(),this.od.getOwnerCity());
        h1.setOd(o1);
        return h1;
    }
}

class twoBHKHouse extends House
{
    int parkingCharge;
    
    twoBHKHouse(int ID, int harea, int hprice,Owner o,int pc) 
    {
        super(ID, harea, hprice,o);
        this.parkingCharge=pc;
    }
    
    @Override
    public String toString() 
    {
        return super.toString()+"twoBHKHouse{" +
        "parkingCharge=" + parkingCharge +
        '}';
    }
}

class threeBHKHouse extends House
{
    int furnitureCharge;
    threeBHKHouse(int ID, int harea, int hprice,Owner o,int fc) 
    {
        super(ID, harea, hprice,o);
        this.furnitureCharge=fc;
    }

    @Override
    public String toString() 
    {
        return super.toString()+"threeBHKHouse{" +
        "furnitureCharge=" + furnitureCharge +
        '}';
    }
}

class HouseStore 
{
    private static final Map<String, House> Housemap = new HashMap<String, House>();
    int noftwoBHK = 0;
    int nofthreeBHK = 0;
    
    public void AddDetails(House h) 
    {
        if (h.getHouseID() == 101) 
        {
            noftwoBHK++;
            Housemap.put("two" + noftwoBHK, h);
        } 
        
        else if (h.getHouseID() == 102) 
        {
            nofthreeBHK++;
            Housemap.put("three" + nofthreeBHK, h);
        }
    }

    public void printHouseStore() 
    {
        for (Map.Entry<String, House> entry : Housemap.entrySet()) 
        {
            System.out.println(entry.getKey() + " = " +
            entry.getValue().toString());
        }
    }

    public static House getHouse(String hname) throws CloneNotSupportedException 
    {
        return (House) Housemap.get(hname).clone();
    }
}

class HouseTest
{
    public static void main(String[] args) throws CloneNotSupportedException 
    {
        Owner o=new Owner("Ansh","Ahmedabad");
        Owner ow=new Owner("Kavya","Dubai");

        House h1 = new twoBHKHouse(101, 120, 450000, o,500);
        House h2 = null;
        House h3=new threeBHKHouse(102,1800,70000000,ow,1000);

        h2=(House) h1.clone();

        System.out.println(h1);

        Owner o1=h2.getOd();

        h2.setHouseID(205);

        o1.setOwnerName("Keya");

        System.out.println(h2);
        System.out.println(h1);
        
        HouseStore hs=new HouseStore();
        hs.AddDetails(h1);
        hs.AddDetails(h2);
        hs.AddDetails(h3);
        hs.printHouseStore();
        House h4= HouseStore.getHouse("three1");
        System.out.println(h4);
    }
}
