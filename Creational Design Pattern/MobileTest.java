import javax.swing.text.DefaultStyledDocument.ElementSpec;

interface Mobile
{
    public abstract void OperatingSystemName();
    public abstract void playMusic();
    public abstract void sendMessage();
}

class Samsung implements Mobile
{
    @Override
    public void OperatingSystemName()
    {
        System.out.println("Android Operating System");
    }

    @Override
    public void playMusic()
    {
        System.out.println("Now Playing Music!!");
    }

    @Override
    public void sendMessage() 
    {
        System.out.println("Sending Message!!");
    }
}

class Apple implements Mobile
{
    @Override
    public void OperatingSystemName()
    {
        System.out.println("Android Operating System");
    }

    @Override
    public void playMusic()
    {
        System.out.println("Now Playing Music!!");
    }

    @Override
    public void sendMessage() 
    {
        System.out.println("Sending Message!!");
    }
}

class Nokia implements Mobile
{
    @Override
    public void OperatingSystemName()
    {
        System.out.println("Symbian Operating System");
    }

    @Override
    public void playMusic()
    {
        System.out.println("Now Playing Music!!");
    }

    @Override
    public void sendMessage() 
    {
        System.out.println("Sending Message!!");
    }
}

class mobileFactory 
{
    public Mobile createMobile(String Mobile_type)
    {
        if(Mobile_type == "Android")
        {
            return new Samsung();
        }

        else if(Mobile_type == "Nokia")
        {
            return new Nokia();
        }

        else if(Mobile_type == "Apple")
        {
            return new Apple();
        }

        else
        {
            return null;
        }
    }
}

public class MobileTest
{
    public static void main(String[] args) 
    {
        mobileFactory factory1 = new mobileFactory();
        Mobile m1 = factory1.createMobile("Apple");
        m1.OperatingSystemName();
        m1.playMusic();
        m1.sendMessage();

        System.out.println("");

        Mobile m2 = factory1.createMobile("Android");
        m2.OperatingSystemName();
        m2.sendMessage();

        System.out.println("");

        Mobile m3 = factory1.createMobile("Nokia");
        m3.OperatingSystemName();
        m3.playMusic();

        System.out.println("");
    }   

}