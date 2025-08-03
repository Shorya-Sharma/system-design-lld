package examples.snakeladder.myimpl;

import java.util.List;

public class RerollOnSixStrategy implements DiceStrategy {
    @Override
    public int roll(List<Dice> diceList) {
        int total = 0;
        for (Dice d : diceList) {
            int roll = d.roll();
            total += roll;
            while (roll == 6) {
                roll = d.roll();
                total += roll;
            }
        }
        return total;
    }
}