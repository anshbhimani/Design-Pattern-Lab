class Account
{
    int Account_number;
    String Account_Holder_Name;

    public int get_Account_Number()
    {
        return Account_number;
    }    

    public String get_Account_Holder_Name()
    {
        return Account_Holder_Name;
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

    public static SingletonBanker getSingletonBanker(int id)
    {
        if(sb == null)
        {
            sb = new SingletonBanker(id);
        }
        return sb;
    }

    public void printValue(SingletonBanker SB)
    {
        System.out.println("Banker ID : "+SB.sb.id);
    }
}

public class SingletonPattern
{
    public static void main(String[] args) 
    {
        SingletonBanker banker1 = SingletonBanker.getSingletonBanker(101);
        banker1.printValue(banker1);
    }
}