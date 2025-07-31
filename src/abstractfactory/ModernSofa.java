package abstractfactory;

public class ModernSofa implements Sofa {
    @Override
    public void create() {
        System.out.println("Creating a Modern Sofa");
    }
}
