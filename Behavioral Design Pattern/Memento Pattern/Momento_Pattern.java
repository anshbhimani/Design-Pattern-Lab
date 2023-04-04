import java.util.List;
import java.util.ArrayList;

// Momento_Pattern
class Momento_Object
{
    private int temperature;
    private int volume;

    public Momento_Object(int t, int v)
    {
        temperature = t;
        volume = v;
    }

    // no setters in momento
    public int getTemperature()
    {
        return temperature;
    }

    public int getVolume()
    {
        return volume;
    }  
}
class OriginatorObject
{
    private int temperature;
    private int volume;

    public OriginatorObject(int t, int v)
    {
        temperature = t;
        volume = v;
    }

    public void setTemperature(int t)
    {
        temperature = t;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public void setVolume(int v)
    {
        volume = v;
    }

    public int getVolume()
    {
        return volume;
    }

    public Momento_Object saveStatetoMomento()
    {
        return new Momento_Object(temperature, volume);
    }

    public void restoreState(Momento_Object m)
    {
        temperature = m.getTemperature();
        volume = m.getVolume();
    } 

    public String toString()
    {
        return "Temperature : " + temperature + " and Volume : " + volume;
    }
}


class CareTakerObject
{
    List<Momento_Object> lm = new ArrayList<Momento_Object>();

    public void addMomentoObject(Momento_Object m)
    {
        lm.add(m);
    }

    public Momento_Object getMomentoObject(int i)
    {
        return lm.get(i);
    }
}

public class Momento_Pattern
{
    public static void main(String[] args) 
    {
        OriginatorObject o1 = new OriginatorObject(15, 20);
        System.out.println(o1);

        CareTakerObject c1 = new CareTakerObject();
        Momento_Object m = o1.saveStatetoMomento();

        c1.addMomentoObject(m);
        
        o1.setTemperature(110);
        o1.setVolume(8502000);
        System.out.println(o1); 

        o1.restoreState(m);
        System.out.println("After Restoring State");
        System.out.println(o1);   
    }
}