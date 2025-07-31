package abstractfactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureStore store1 = new FurnitureStore(modernFactory);
        store1.furnishStore();

        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        FurnitureStore store2 = new FurnitureStore(victorianFactory);
        store2.furnishStore();
    }
}
