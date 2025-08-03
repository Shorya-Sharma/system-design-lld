package examples.snakeladder.myimpl;
import java.util.Random;

public class Dice {
    private int min = 1;
    private int max = 6;
    private Random rand = new Random();

    public int roll() {
        return rand.nextInt(max - min + 1) + min;
    }
}