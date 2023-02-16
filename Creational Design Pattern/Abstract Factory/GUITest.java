interface Button
{
    public abstract void createButton();    
}

interface Checkbox
{
    public abstract void createCheckbox();
}

class Windows_Button implements Button
{
    @Override
    public void createButton()
    {
        System.out.println("Creating Windows Button !!");
    }
}

class MacOs_Button implements Button
{
    @Override
    public void createButton() 
    {
        System.out.println("Creating MacOs Button !!");
    }
}

class Windows_Checkbox implements Checkbox
{
    @Override
    public void createCheckbox()
    {
        System.out.println("Creating Windows Checkbox !!");
    }
}

class MacOs_Checkbox implements Checkbox
{
    @Override
    public void createCheckbox() 
    {
        System.out.println("Creating MacOs Checkbox !!");    
    }
}

interface GUI_Factory
{
    public abstract Button createButton(String element);
    public abstract Checkbox createCheckbox(String element);
}

class Windows_Factory implements GUI_Factory
{
    //return object
    @Override
    public Button createButton(String element)
    {
        if(element == "Windows")
        {
            return new Windows_Button();
        }
        
        else
        {
            return null;
        }
    }

    @Override
    public Checkbox createCheckbox(String element)
    {
        if(element == "Windows")
        {
            return new Windows_Checkbox();
        }
        
        else
        {
            return null;
        }
    }
}

class MacOs_Factory implements GUI_Factory
{
    @Override
    public Button createButton(String element)
    {
        if(element == "MacOs")
        {
            return new MacOs_Button();
        }
        
        else
        {
            return null;
        }
    }

    @Override
    public Checkbox createCheckbox(String element)
    {
        if(element == "MacOs")
        {
            return new MacOs_Checkbox();
        }
        
        else
        {
            return null;
        }
    }
}

class Factory
{
    public GUI_Factory createGUI(String GUI_Type)
    {
        if(GUI_Type == "Windows")
        {
            return new Windows_Factory();
        }

        else if(GUI_Type == "MacOs")
        {
            return new MacOs_Factory();
        }

        else
        {
            return null;
        }
    }
}


public class GUITest
{
    public static void main(String[] args) 
    {
        GUI_Factory w1 = new Windows_Factory();
        GUI_Factory p1 = new MacOs_Factory();
        
        Button c1,c2;
        Checkbox t1,t2;

        c1 = w1.createButton("Windows");
        c2 = p1.createButton("MacOs");

        t1 = w1.createCheckbox("Windows");
        t2 = p1.createCheckbox("MacOs");

        c1.createButton();
        c2.createButton();
        t1.createCheckbox();
        t2.createCheckbox();
    }
}
