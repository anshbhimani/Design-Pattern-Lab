import java.util.HashMap;
import java.util.Map;

class PlayerFlyWeight
{
    String type;
    String task;
    String colorCode;

    public PlayerFlyWeight(String type)
    {
        if(type == "CT")
        {
            this.colorCode = "ORANGE";
            this.task = "Defuse Bomb";
        }

        if(type == "T")
        {
            this.colorCode = "GREEN";
            this.task = "Plant Bomb";
        }
    }
}

class Player
{
    String weapon;
    int pos_x;
    int pos_y;
    PlayerFlyWeight pf;

    public Player(PlayerFlyWeight pf)
    {
        this.pf = pf;
    }

    public void createPlayer(int pos_x, int pos_y)
    {
        this.pos_x = pos_x;
        this.pos_y = pos_y;

        System.out.println("Player Position is : " + pos_x  + " , "+ pos_y);
    }

    public void showStats()
    {
        // which weapon more popular in each of two categoty
    }
}

class PlayerFactory
{
    static int count_terrorist;
    static int count_counter_terrorist;

    Map<String, PlayerFlyWeight> player_map = new HashMap<String, PlayerFlyWeight>();   
    PlayerFlyWeight plw = null;

    public PlayerFlyWeight createPlayer(String type, String color)
    {
        if(player_map.containsKey(Type))
        {
            plw = player_map.get(Type);
        }

        else if(Type.equalsIgnoreCase("Terrorist"))
        {
            tfw = new TreeFlyWeight()
        }
    }
}