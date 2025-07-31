package abstractfactory;

public class FurnitureStore {
    private FurnitureFactory furnitureFactory;

    public FurnitureStore(FurnitureFactory factory) {
        this.furnitureFactory = factory;
    }

    public void furnishStore() {
        Chair chair = furnitureFactory.createChair();
        Sofa sofa = furnitureFactory.createSofa();
        chair.create();
        sofa.create();
    }
}
