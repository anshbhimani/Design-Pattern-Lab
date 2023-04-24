import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class PlayerFlyWeight {
    String type;
    String task;
    String colorCode;

    public PlayerFlyWeight(String type) {
        if (type.equals("CT")) {
            this.colorCode = "ORANGE";
            this.task = "Defuse Bomb";
        }

        if (type.equals("T")) {
            this.colorCode = "GREEN";
            this.task = "Plant Bomb";
        }
        this.type = type;
    }
}

class Player {
    String weapon;
    int pos_x;
    int pos_y;
    PlayerFlyWeight pf;

    public Player(PlayerFlyWeight pf) {
        this.pf = pf;
    }

    public void createPlayer(int pos_x, int pos_y) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;

        System.out.println("Player Position is : " + pos_x + " , " + pos_y);
    }

    public void showStats() {
        if (pf.type.equals("T")) {
            System.out.println("Favorite Primary Weapon : AK-47");
            System.out.println("Favorite Secondary Weapon : .40 Dual Elites");
        } else if (pf.type.equals("CT")) {
            System.out.println("Favorite Primary Weapon : Maverick M4A1 Carbine");
            System.out.println("Favorite Secondary Weapon : ES Five-seven");
        }
    }
}

class PlayerFactory {
    static int count_terrorist;
    static int count_counter_terrorist;

    Map<String, PlayerFlyWeight> player_map = new HashMap<String, PlayerFlyWeight>();
    PlayerFlyWeight pfw = null;

    public PlayerFlyWeight createPlayer(String type, String color) {
        if (player_map.containsKey(type)) {
            pfw = player_map.get(type);
        } else if (type.equalsIgnoreCase("T")) {
            pfw = new PlayerFlyWeight("T");
            count_terrorist++;
        } else if (type.equalsIgnoreCase("CT")) {
            pfw = new PlayerFlyWeight("CT");
            count_counter_terrorist++;
        } else {
            System.out.println("Invalid Player Type");
        }
        player_map.put(type, pfw);
        return pfw;
    }
}

public class Counter_Strike {
    public static void main(String[] args) {
        boolean more_players = true;
        Scanner scan = new Scanner(System.in);
        List<Player> players = new ArrayList<Player>();

        while (more_players) {
            PlayerFactory playerfact = new PlayerFactory();

            System.out.println("Enter the number of Players You want to create");
            int numPlayers = scan.nextInt();
            System.out.println("Enter the type of Player You want to create");
            String playerType = scan.next();

            System.out.println("Enter x position of player object: ");
            int x = scan.nextInt();
            System.out.println("Enter y position of player object: ");
            int y = scan.nextInt();

            for (int i = 0; i < numPlayers; i++) {
                PlayerFlyWeight playerFlyweight = playerfact.createPlayer(playerType, "");
                Player p1 = new Player(playerFlyweight);
                p1.createPlayer(x++, y++);
                players.add(p1);
            }

            System.out.println("Do you want to create more players? ");
            more_players = scan.nextBoolean();
        }

        // show stats
        System.out.println("Stats of all players:");
        for (Player player : players) {
            player.showStats();
        }

        try{}
        catch(Exception e){}

        finally
        {
            scan.close();
        }
    }
}