class Computer
{
    private int HDD_Size;
    private int ram_Size;
    private String processor_Make;
    private String processor_type;
    private double monitor_Size;
    private String monitor_Type;
    private String Operating_System_Configuration;
    private String device_Driver;

    private int Computer_Id;

    public void setComputerID(int id)
    {
        this.Computer_Id = id;
    }

    public Computer(int ID)
    {
        setComputerID(ID);
    }

    public void setHDD(int HDD_Size)
    {
        this.HDD_Size = HDD_Size;
    }

    public void setRam(int ram_Size) 
    {
        this.ram_Size = ram_Size;
    }

    public void setProcessorMake(String processor_Make)
    {
        this.processor_Make = processor_Make;
    }
    
    public void setProcessorType(String processor_type) 
    {
        this.processor_type = processor_type;   
    }

    public void setMonitorSize(double monitor_Size)
    {
        this.monitor_Size = monitor_Size;
    }

    public void setOperatingSystemConfig(String Operating_System_Configuration)
    {
        this.Operating_System_Configuration = Operating_System_Configuration;
    }

    public void setDeviceDriver(String device_Driver)
    {
        this.device_Driver = device_Driver;
    }

    public void setMonitorType(String monitor_Type)
    {
        this.monitor_Type = monitor_Type;
    }

    @Override
    public String toString()
    {
        return "Computer of ID : " + Computer_Id + "\n HDD = " + HDD_Size + "\n RAM = " + ram_Size + "\n Processor : " + processor_Make
         + " of Type : " + processor_type + "\n Monitor Type : " + monitor_Type + 
        " of Size : " + monitor_Size + "\n having OS : " + Operating_System_Configuration + 
        "\n Device Driver : " + device_Driver;
    }
}

abstract class Computer_Builder
{
    protected Computer c1;
    
    public void createNewComputer()
    {
        c1 = new Computer(10);
    }

    abstract void configMonitorSize();
    abstract void configOS();
    abstract void configProcessorMake();
    abstract void configProcessorType();
    abstract void configDeviceDriver();
    abstract void configRAM();
    abstract void configHDD();
    abstract void configMonitorType();

    abstract Computer returnComputer();
}

class Server_Computer_Builder extends Computer_Builder
{
    @Override
    public void createNewComputer()
    {
        c1 = new Computer(1);
    }

    @Override
    public void configHDD()
    {
        c1.setHDD(1000);
    }

    @Override
    public void configMonitorSize()
    {
        c1.setMonitorSize(14.5);
    }

    @Override
    public void configOS()
    {
        c1.setOperatingSystemConfig("Linux");
    }

    @Override
    public void configProcessorMake()
    {
        c1.setProcessorType("INTEL");
    }

    @Override
    public void configProcessorType()
    {
        c1.setProcessorType("Deca Core");
    }

    @Override
    public void configDeviceDriver()
    {
        c1.setDeviceDriver(null);
    }

    @Override
    public void configRAM()
    {
        c1.setRam(128);
    }

    @Override
    public void configMonitorType()
    {
        c1.setMonitorType(null);
    }

    @Override
    Computer returnComputer()
    {
        return c1;
    }
}

class Personal_Computer_Builder extends Computer_Builder
{
    @Override
    public void createNewComputer()
    {
        c1 = new Computer(1);
    }

    @Override
    public void configHDD()
    {
        c1.setHDD(512);
    }

    @Override
    public void configMonitorSize()
    {
        c1.setMonitorSize(14.5);
    }

    @Override
    public void configOS()
    {
        c1.setOperatingSystemConfig("Windows");
    }

    @Override
    public void configProcessorMake()
    {
        c1.setProcessorType("INTEL");
    }

    @Override
    public void configProcessorType()
    {
        c1.setProcessorType("Hexa Core");
    }

    @Override
    public void configDeviceDriver()
    {
        c1.setDeviceDriver(null);
    }

    @Override
    public void configRAM()
    {
        c1.setRam(8);
    }

    @Override
    public void configMonitorType()
    {
        c1.setMonitorType("OLED");
    }

    @Override
    Computer returnComputer()
    {
        return c1;
    }
}

//class Director (Hardware engineer in this case)
// this class has object of above class

// main class(test class)

class Hardware_Engineer // the director class
{
    private Computer_Builder Computer_Builder_1;
    private Computer c1;
    
    public void setComputer(Computer_Builder cbs){
        this.Computer_Builder_1=cbs;
    }

    public void configComputer()
    {
        Computer_Builder_1.configHDD();
        Computer_Builder_1.configDeviceDriver();;
        Computer_Builder_1.configMonitorSize();
        Computer_Builder_1.configMonitorType();
        Computer_Builder_1.configOS();
        Computer_Builder_1.configRAM();
        Computer_Builder_1.configProcessorMake();
        Computer_Builder_1.configProcessorType();
    }

    public Computer returnComputer()
    {
        c1 = Computer_Builder_1.returnComputer();
        return c1;
    }

    
}

public class Computer_Builder_Pattern
{
    public static void main(String[] args) 
    {
        Hardware_Engineer e1 = new Hardware_Engineer();
        Computer_Builder b1 = new Server_Computer_Builder();

       b1.createNewComputer();
       e1.setComputer(b1);
       e1.configComputer();
       Computer c1 = e1.returnComputer();
       System.out.println(c1);

      System.out.println();  
      Computer_Builder b2 = new Personal_Computer_Builder();
      b2.createNewComputer();
      e1.setComputer(b2);
      e1.configComputer();
      Computer c2 = e1.returnComputer();
      System.out.println(c2); 
    }
}