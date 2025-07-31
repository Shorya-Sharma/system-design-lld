package abstractfactory;

public class VictorianChair implements Chair {
    @Override
    public void create() {
        System.out.println("Creating a Victorian Chair");
    }
}
