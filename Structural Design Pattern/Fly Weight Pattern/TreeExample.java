import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TreeFlyWeight
{
    String Type;
    String color;

    public TreeFlyWeight(String Type, String color){
        this.Type= Type;
        this.color=color;
    }
}

class tree
{
    int x;
    int y;
    TreeFlyWeight tf;
    public tree(TreeFlyWeight tf){
        this.tf=tf;
    }

    public void plantTree(int x, int y){
        this.x=x;
        this.y=y;
        System.out.println(tf.Type + " planted at (" + x + " , " + y + ")");
    }
}


class TreeFactory
{
    static int count_neem;
    static int count_oak;
    Map<String, TreeFlyWeight> tm = new HashMap<String, TreeFlyWeight>();
    TreeFlyWeight tfw = null;

    public TreeFlyWeight createTree(String Type, String color){
        if(tm.containsKey(Type)){
            tfw = tm.get(Type);
        }
        else if(Type.equalsIgnoreCase("Oak_tree")){
            tfw = new TreeFlyWeight("Oak_tree", "brown");
            count_oak++;
        }
        else if (Type.equalsIgnoreCase("neem_tree")) {
            tfw = new TreeFlyWeight("neem_tree", "green");
            count_neem++;
        }
        else{
            System.out.println("invalid type of tree!!");
            tm.put(Type, tfw);
        }
        return tfw;
    }
}

public class TreeExample 
{
    public static void main(String[] args) {
        boolean more = true;
        Scanner sc = new Scanner(System.in);

        while(more) {

            TreeFactory treeFactory = new TreeFactory();

            System.out.println("enter the number of tree objects to be created: ");
            int n = sc.nextInt();
            System.out.println("enter the name of tree object: ");
            String s = sc.next();
            System.out.println("enter the color of tree object: ");
            String cl = sc.next();

            System.out.println("enter x position of tree object: ");
            int x = sc.nextInt();
            System.out.println("enter y position of tree object: ");
            int y = sc.nextInt();

            for (int i = 0; i < n; i++) 
            {
                TreeFlyWeight TreeFlyweight = treeFactory.createTree(s, cl);
                tree t1 = new tree(TreeFlyweight);
                t1.plantTree(x++,y++);
            }

            System.out.println("Do you want to create more tree ? ");
            more = sc.nextBoolean();
        }

        System.out.println("maximum density of tree: " + Math.max(TreeFactory.count_neem,TreeFactory.count_oak) );
    }
}
