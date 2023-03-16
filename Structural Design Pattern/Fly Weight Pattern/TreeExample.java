import java.util.HashMap;
import java.util.Map;

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
    String Type;
    String color;
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
    public static void main(String[] args) {
        
    }
}
