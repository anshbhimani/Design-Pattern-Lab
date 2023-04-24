import java.util.ArrayList;
import java.util.List;

class SubjectEntity
{
    private int numberState;
    private List<ObserverEntity> lm = new ArrayList<ObserverEntity>();

    public void setNumberState(int numberState) 
    {
        this.numberState = numberState;
        notifyAllObservers();
    }   

    public int getNumberState() 
    {
        return numberState;
    } 

    public void subscribeObserver(ObserverEntity e)
    {
        lm.add(e);
    }

    public void unsubscribeObserver(ObserverEntity e)
    {
        lm.remove(e);
    }

    public void notifyAllObservers()
    {
        for(ObserverEntity ob : lm)
        {
            ob.update();
        }
    }
}

abstract class ObserverEntity
{
    SubjectEntity se;
    abstract public void update();
}

class BinaryObserverEntity extends ObserverEntity
{
    public BinaryObserverEntity(SubjectEntity e)
    {
        se = e;
    }

    @Override
    public void update()
    {
        int n = se.getNumberState();
        System.out.println("Binary Observer represents number : " + n + " to Binary : " + Integer.toBinaryString(n));
    }
}

class HexObserver extends ObserverEntity
{
    public HexObserver(SubjectEntity e)
    {
        se = e;
    }

    @Override
    public void update()
    {
        int n = se.getNumberState();
        System.out.println("Hex Observer represents number : " + n + " to Hexadecimal : " + Integer.toHexString(n));
    }
}

class OctalObserver extends ObserverEntity
{
    public OctalObserver(SubjectEntity e)
    {
        se = e;
    }

    @Override
    public void update()
    {
        int n = se.getNumberState();
        System.out.println("Octal Observer represents number : " + n + " to Octal : " + Integer.toOctalString(n));
    }
}

class ObserverDemo
{
    public static void main(String[] args) 
    {
        SubjectEntity se = new SubjectEntity();
        ObserverEntity ob1 = new BinaryObserverEntity(se);
        ObserverEntity ob2 = new HexObserver(se);
        ObserverEntity ob3 = new OctalObserver(se);

        se.subscribeObserver(ob1);
        se.subscribeObserver(ob2);
        se.subscribeObserver(ob3);
        se.setNumberState(9);
    }
}


// observers - morning news bulletin and evening news bulletin
// morning - 
// evening - 5 to  12