import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// we use this pattern for creating large nos of objects of a class
class TreeFlyWeight{
    String Type;
    String color;

    public TreeFlyWeight(String Type, String color){
        this.Type= Type;
        this.color=color;
        System.out.println(Type);
    }
}

class tree{
    int x;
    int y;
    TreeFlyWeight tf;
    public tree(TreeFlyWeight tf){
        this.tf=tf;
    }

    public void plantTree(int x, int y){
        this.x=x;
        this.y=y;
        System.out.println(x + y);
    }
}


class TreeFactory{
    Map<String, TreeFlyWeight> tm = new HashMap<String, TreeFlyWeight>();
    TreeFlyWeight tfw = null; 

    public TreeFlyWeight createTree(String Type, String color){
        if(tm.containsKey(Type)){
            tfw = tm.get(Type);
        }
        else if(Type.equalsIgnoreCase("Oak_tree")){
            tfw = new TreeFlyWeight("Oak_tree", "brown");
        }
        else if (Type.equalsIgnoreCase("neem_tree")) {
            tfw = new TreeFlyWeight("neem_tree", "green");
        }
        else{
            System.out.println("invalid type of tree!!");
            tm.put(Type, tfw);
        }
        return tfw;
    }
}

public class TreeExample {
    public static void main(String[] args) 
    {
        TreeFactory fact1 = new TreeFactory();
        Scanner sc = new Scanner("System.in");

        System.out.println("Enter the number of Tree to be created : ");
        int number_of_trees = sc.nextInt();
        
        System.out.println("Enter Name of the Tree you want to create  : ");
        String name_of_tree = sc.next();

        System.out.println("Enter Color of the Tree you want to create  : ");
        String color_of_tree = sc.next();
        
    }
}
