package abstractfactory;

public class VictorianSofa implements Sofa {
    @Override
    public void create() {
        System.out.println("Creating a Victorian Sofa");
    }
}
