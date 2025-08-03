package examples.elevatorsystem.myimpl;

public class Main {
    public static void main(String[] args) {
        Building building = new Building(5, 2);

        // Simulate pressing buttons
        building.getFloors().get(2).getLiftButton().pressUp();
        building.getFloors().get(4).getLiftButton().pressDown();
    }
}
