class Account
{
    private int Account_Balance;
    private int Account_Number;
    private String Account_Holder_Name;

    public int get_Account_Number()
    {
        return Account_Number;
    }    

    public int get_Account_Balance()
    {
        return Account_Balance;
    }

    public String get_Account_Holder_Name()
    {
        return Account_Holder_Name;
    }  

    Account(int balance, String name)
    {
        Account_Balance = balance;
        Account_Holder_Name = name;
    }

    public void get_Details()
    {
        System.out.println("Account Holder Name : " + this.get_Account_Holder_Name());
        System.out.println("Account Balance is  : " + this.get_Account_Balance());
    }
}

class SingletonBanker
{
    int id;
    private static SingletonBanker sb = null;

    private SingletonBanker(int id)
    {
        this.id = id;
    }

    public static SingletonBanker getSingletonBankerInstance(int id)
    {
        if(sb == null)
        {
            sb = new SingletonBanker(id);
        }
        return sb;
    }

    public void getID()
    {
        System.out.println("Banker ID : "+id);
    }

    public Account openNewAccount(String name, int balance)
    {
        return new Account(balance, name);
    }
}

public class SingletonPattern
{
    public static void main(String[] args) 
    {
        SingletonBanker banker1 = SingletonBanker.getSingletonBankerInstance(102);
        Account a1 = banker1.openNewAccount("Ansh Bhimani",10000000);

        SingletonBanker banker2 = SingletonBanker.getSingletonBankerInstance(101);
        Account a2 = banker2.openNewAccount("Amrut Bhimani",700000);

        a1.get_Details();
        a2.get_Details();

        banker1.getID();
        banker2.getID();
    }
}