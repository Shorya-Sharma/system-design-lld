package abstractfactory;

public class ModernChair implements Chair {
    @Override
    public void create() {
        System.out.println("Creating a Modern Chair");
    }
}
