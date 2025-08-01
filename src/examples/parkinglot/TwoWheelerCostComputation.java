package examples.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class TwoWheelerCostComputation implements CostComputationStrategy {
    @Override
    public double computeCost(Ticket ticket) {
        LocalDateTime entry = ticket.getEntryTime();
        LocalDateTime exit = ticket.getExitTime();

        if (exit == null || exit.isBefore(entry)) {
            throw new IllegalArgumentException("Invalid exit time in ticket.");
        }

        long hours = Math.max(1, Duration.between(entry, exit).toHours());
        return hours * 10.0; // ₹10 per hour
    }
}