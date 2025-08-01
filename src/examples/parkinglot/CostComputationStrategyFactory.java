package examples.parkinglot;

public class CostComputationStrategyFactory {
    public static CostComputationStrategy getStrategy(VehicleType type) {
        return switch (type) {
            case TWO_WHEELER -> new TwoWheelerCostComputation();
            case FOUR_WHEELER -> new FourWheelerCostComputation();
            default -> throw new IllegalArgumentException("Unsupported vehicle type");
        };
    }
}