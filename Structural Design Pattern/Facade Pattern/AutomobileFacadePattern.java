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
        System.out.println("Starting Car!!");
    }

    @Override
    public void stop()
    {
        System.out.println("Stopping Car!!");
    }

    @Override
    public void accelerate(float acceleration)
    {
        System.out.println("Car Accelerating at " + acceleration);
    }
}

class Bus implements Automobile
{
    @Override
    public void start()
    {
        System.out.println("Starting Bus!!");
    }

    @Override
    public void stop()
    {
        System.out.println("Stopping Bus!!");
    }

    @Override
    public void accelerate(float acceleration)
    {
        System.out.println("Bus Accelerating at " + acceleration);
    }
}

class Truck implements Automobile
{
    @Override
    public void start()
    {
        System.out.println("Starting Truck!!");
    }

    @Override
    public void stop()
    {
        System.out.println("Stopping Truck!!");
    }

    @Override
    public void accelerate(float acceleration)
    {
        System.out.println("Truck Accelerating at " + acceleration);
    }
}

class AutomobileMaker
{
    private Car car1;
    private Bus bus1;
    private Truck truck1;

    public AutomobileMaker()
    {
        car1 = new Car();
        bus1 = new Bus();
        truck1 = new Truck();
    }

    public void Start(String type)
    {
        if(type == "Car")
        {
            car1.start();
        }

        else if(type == "Bus")
        {
            bus1.start();
        }

        else if(type == "Truck")
        {
            truck1.start();
        }

        else
        {
            System.out.println("Please input valid type");
        }
    }

    public void Stop(String type)
    {
        if(type == "Car")
        {
            car1.stop();
        }

        else if(type == "Bus")
        {
            bus1.stop();
        }

        else if(type == "Truck")
        {
            truck1.stop();
        }

        else
        {
            System.out.println("Please input valid type");
        }
    }

    public void Accelerate(String type,float acceleration)
    {
        if(type == "Car" && acceleration>0)
        {
            car1.accelerate(acceleration);
        }

        else if(type == "Bus" && acceleration>0)
        {
            bus1.accelerate(acceleration);
        }

        else if(type == "Truck" && acceleration>0)
        {
            truck1.accelerate(acceleration);
        }

        else
        {
            System.out.println("Please input valid type");
        }
    }
}

public class AutomobileFacadePattern
{
    public static void main(String[] args) 
    {
        AutomobileMaker cm = new AutomobileMaker();
        cm.Accelerate("Car", 55);
        
        cm.Start("Truck");
        cm.Stop("Bus");
    }
}