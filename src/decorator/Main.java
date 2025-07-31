package decorator;

public class Main {
    public static void main(String[] args) {
        // Base pizza
        Pizza vegPizza = new VegPizza(200);
        System.out.println("Base Veg Pizza Cost: " + vegPizza.getPizzaCost());

        // Add Extra Cheese
        Pizza cheesePizza = new ExtraCheesePizza(vegPizza, 50);
        System.out.println("Veg Pizza with Extra Cheese Cost: " + cheesePizza.getPizzaCost());
    }
}
