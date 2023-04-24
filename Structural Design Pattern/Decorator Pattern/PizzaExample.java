interface Pizza 
{
    public String getPizzaDescription();
    public double getPizzaCost();
}

class MexicanPizza implements Pizza 
 {
    public String getPizzaDescription() 
    {
        return "Basic Pizza";
    }
 
    public double getPizzaCost() {
        return 4.0;
    }
}

 abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
 
    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
 
    public String getPizzaDescription() {
        return pizza.getPizzaDescription();
    }
 
    public double getPizzaCost() {
        return pizza.getPizzaCost();
    }
}

 class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }
 
    public String getPizzaDescription() {
        return pizza.getPizzaDescription() + ", Cheese";
    }
 
    public double getPizzaCost() {
        return pizza.getPizzaCost() + 1.0;
    }
}

 class ToppingDecorator extends PizzaDecorator {
    public ToppingDecorator(Pizza pizza) {
        super(pizza);
    }
 
    public String getPizzaDescription() {
        return pizza.getPizzaDescription() + ", Topping";
    }
 
    public double getPizzaCost() {
        return pizza.getPizzaCost() + 2.0;
    }
}

public class PizzaExample {
    public static void main(String args[]) {
        Pizza MexicanPizza = new MexicanPizza();
        Pizza cheesePizza = new CheeseDecorator(MexicanPizza);
        Pizza meatPizza = new ToppingDecorator(cheesePizza);
 
        System.out.println("Description: " + meatPizza.getPizzaDescription());
        System.out.println("Cost: " + meatPizza.getPizzaCost());
    }
}

