package decorator;

public class VegPizza extends Pizza {
    private final int pizzaCost;


    public VegPizza(int cost) {
        this.pizzaCost = cost;
    }

    @Override
    public int getPizzaCost() {
        return pizzaCost;
    }
}
