package examples.snakeladder.myimpl;
import java.util.List;

public class DiceController {
    private List<Dice> diceList;
    private DiceStrategy strategy;
    private List<SpecialObject> specialObjects;

    public DiceController(List<Dice> diceList, DiceStrategy strategy, List<SpecialObject> specialObjects) {
        this.diceList = diceList;
        this.strategy = strategy;
        this.specialObjects = specialObjects;
    }

    public int roll() {
        return strategy.roll(diceList);
    }

    public Position adjustPosition(Position position) {
        for (SpecialObject so : specialObjects) {
            position = so.move(position);
        }
        return position;
    }
}