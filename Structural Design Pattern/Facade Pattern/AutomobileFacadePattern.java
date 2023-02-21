interface Automobile
{
    public void start();
    public void stop();
    public void accelerate(float acceleration);
}

class Car implements Automobile
{
    @Override
    public void start()
    {
        System.out.println("Starting ");
    }
}

public class AutomobileFacadePattern
{

}