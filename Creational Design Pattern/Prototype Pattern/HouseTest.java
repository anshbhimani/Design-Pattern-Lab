import java.lang.*;
import java.util.HashMap;
import java.util.Map;


class House implements Cloneable{
    private int houseArea;
    private int housePrice;
    private int houseID;

    public void setHouseID(int houseIDs) {
        this.houseID = houseIDs;
    }

    public void setHouseArea(int houseArea) {
        this.houseArea = houseArea;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    House(int ID,int harea,int hprice){
        this.houseID=ID;
        this.houseArea=harea;
        this.housePrice=hprice;
    }

    @Override
    public String toString() {
        return "House {" +"houseArea = " + houseArea + ", housePrice = " + housePrice +", houseID = " + houseID +
        '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class twoBHKHouse extends House{
    int parkingCharge;
    twoBHKHouse(int ID, int harea, int hprice,int pc) {
        super(ID, harea, hprice);
        this.parkingCharge=pc;
    }

    @Override
    public String toString() {
        return super.toString()+"twoBHKHouse (" + "parkingCharge = " + parkingCharge + ')';
    }
}


class threeBHKHouse extends House{
    int furnitureCharge;
    threeBHKHouse(int ID, int harea, int hprice,int fc) {
        super(ID, harea, hprice);
        this.furnitureCharge=fc;
    }

    @Override
    public String toString() {
        return super.toString()+"threeBHKHouse (" +"furnitureCharge = " + furnitureCharge +')';
    }
}


class HouseStore{
    private static final Map<String,House>Housemap=new HashMap<String,House>();
    static{
        Housemap.put("two",new twoBHKHouse(101,1200,4000000,500));
        Housemap.put("three",new threeBHKHouse(102,1800,6000000,80000));
    }

    public static House getHouse(String hname) throws CloneNotSupportedException{
        return (House)Housemap.get(hname).clone();
    }

}

class PrototypeCloneTest{
    public static void main(String[] args) throws CloneNotSupportedException {
        House h1 = new twoBHKHouse(101, 1200, 400000, 500);
        House h2 = null;
        try {
            h2 = (House) h1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }


        System.out.println(h1);
        System.out.println(h2);

        House h3= HouseStore.getHouse("three");
        System.out.println(h3);
    }
}