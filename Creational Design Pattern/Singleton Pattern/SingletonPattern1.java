final class Singleton 
{
    private static Singleton instance;
    private String value;

    private Singleton(String value) 
    {
        this.value = value;
    }

    public String getValue()
    {   
        return value;
    } 
    
    public static Singleton getInstance(String value) 
    {
        if (instance == null) 
        {
            instance = new Singleton(value);
        }
        return instance;
    }
}

class SingletonPattern1 
{
    public static void main(String[] args) 
    {
        System.out.println("If same name, then singleton was reused(As expexted!!)" + "\n" +
        "If different name values, then 2 singletons were created (wrong!!)" + "\n\n" +
        "RESULT:" + "\n");
        Singleton singleton = Singleton.getInstance("One-and-Only-One");
        Singleton anotherSingleton = Singleton.getInstance("Second-instance");
        System.out.println(singleton.getValue());
        System.out.println(anotherSingleton.getValue());
    }
}
