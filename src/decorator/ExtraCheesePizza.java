package decorator;

public class ExtraCheesePizza extends PizzaDecorator {
    private final Pizza basePizza;
    private final int cheeseCost;

    public ExtraCheesePizza(Pizza basePizza, int cheeseCost) {
        this.basePizza = basePizza;
        this.cheeseCost = cheeseCost;
    }

    @Override
    public int getPizzaCost() {
        return cheeseCost + basePizza.getPizzaCost();
    }
}
