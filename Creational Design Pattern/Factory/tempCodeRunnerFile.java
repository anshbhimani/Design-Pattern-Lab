abstract class Bill
{
    private int bill_Unit;
    private float bill_UnitRate;
    public static int billId = 1000;

    public int getBillID() // getter of bill id
    {
        return billId;
    }    

    public int getBillUnit() // getter of bill uint
    {
        return bill_Unit;
    }

    public float getBillUnitRate() // getter of bill unit rate
    {
        return bill_UnitRate;
    }

    public void setBillID(int id)
    {
        billId = id;
    }

    public abstract float calculateBill();

    public abstract void printBill();

}

class mobileBill extends Bill
{
    int mobilebill_unit = getBillUnit();
    float mobilebill_UnitRate = getBillUnitRate();
    float mobile_bill;
    static int mobile_bill_id = 100;

    mobileBill()
    {
        billId ++;
        mobile_bill_id ++;
        mobilebill_UnitRate = 4;
        mobilebill_unit = 0;
        mobile_bill = mobilebill_UnitRate * mobilebill_unit;
    }

    mobileBill(int uints,float rate)
    {
        billId++;
        mobile_bill_id ++;
        mobilebill_unit = uints;
        mobilebill_UnitRate = rate;
    }

    @Override
    public float calculateBill()
    {
        mobile_bill = mobilebill_unit * mobilebill_UnitRate;
        return mobile_bill;
    }

    @Override
    public void printBill()
    {
        System.out.println("Your Mobile Bill is as follows : ");
        System.out.println("Your Bill id is : " + billId);
        System.out.println("Your Mobile Bill Id : M-" + mobile_bill_id);
        System.out.println("Your total mobile bill is " + mobile_bill);
    }
}

class electricityBill extends Bill
{
    float electricity_bill;
    int electricity_bill_unit = getBillUnit();
    float electricity_bill_UnitRate = getBillUnitRate();
    static int electricity_bill_id = 100;

    electricityBill()
    {
        billId++;
        electricity_bill_id++;
        electricity_bill_UnitRate = 6;
        electricity_bill_unit = 0;
        electricity_bill = electricity_bill_UnitRate * electricity_bill_unit;
    }

    electricityBill(int units,float rate)
    {
        billId++;
        electricity_bill_id++;
        electricity_bill_unit = units;
        electricity_bill_UnitRate = rate;
    }

    @Override
    public float calculateBill()
    {
        electricity_bill = electricity_bill_unit * electricity_bill_UnitRate;
        return electricity_bill;
    }

    @Override
    public void printBill()
    {
        System.out.println("Your Electricity Bill is as follows : ");
        System.out.println("Your Bill id is : " + billId);
        System.out.println("Your Electricity Bill Id : E-" + electricity_bill_id);
        System.out.println("Your total electricity bill is " + electricity_bill);
    }
}

class gasBill extends Bill
{
    float gas_bill;
    int gas_bill_unit = getBillUnit();
    float gas_bill_UnitRate = getBillUnitRate();
    static int gas_bill_id = 100;

    gasBill()
    {
        billId++;
        gas_bill_id++;
        gas_bill_UnitRate = 14;
        gas_bill_unit = 0;
        gas_bill = gas_bill_unit * gas_bill_UnitRate;
    }

    gasBill(int units,float rate)
    {
        billId++;
        gas_bill_id++;
        gas_bill_unit = units;
        gas_bill_UnitRate = rate;
    }

    @Override
    public float calculateBill()
    {
        gas_bill = gas_bill_unit * gas_bill_UnitRate;
        return gas_bill;
    }

    @Override
    public void printBill()
    {
        System.out.println("Your Gas Bill is as follows : ");
        System.out.println("Your Bill id is : " + billId);
        System.out.println("Your Gas Bill Id : G-" + gas_bill_id);
        System.out.println("Your total gas bill is " + gas_bill);
    }
}

public class BillTest
{
    public static void main(String[] args) 
    {
        Bill b1 = new mobileBill(500,20);
        b1.calculateBill();
        b1.printBill();
        System.out.println(" ");

        Bill b2 = new electricityBill(20, 50);
        b2.calculateBill();
        b2.printBill();
        System.out.println(" ");

        Bill b3 = new gasBill(45,90);
        b3.calculateBill();
        b3.printBill();
        System.out.println(" ");

        Bill b4 = new mobileBill(50,100);
        b4.calculateBill();
        b4.printBill();
        System.out.println(" ");

        Bill g1 = new gasBill();
        g1.calculateBill();
        g1.printBill();
        System.out.println(" ");
    }
}