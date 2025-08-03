package examples.snakeladder.myimpl;

import java.util.List;

public class StandardDiceStrategy implements DiceStrategy {
    @Override
    public int roll(List<Dice> diceList) {
        return diceList.stream().mapToInt(Dice::roll).sum();
    }
}