package examples.snakeladder.myimpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int boardSize = 10;

        // Create players
        Player p1 = new Player("Alice", Position.fromIndex(0, boardSize));
        Player p2 = new Player("Bob", Position.fromIndex(0, boardSize));
        List<Player> players = Arrays.asList(p1, p2);

        // Create snakes and ladders
        SpecialObject snake1 = new Snake(Position.fromIndex(97, boardSize), Position.fromIndex(12, boardSize));
        SpecialObject snake2 = new Snake(Position.fromIndex(62, boardSize), Position.fromIndex(25, boardSize));
        SpecialObject ladder1 = new Ladder(Position.fromIndex(5, boardSize), Position.fromIndex(56, boardSize));
        SpecialObject ladder2 = new Ladder(Position.fromIndex(20, boardSize), Position.fromIndex(77, boardSize));
        List<SpecialObject> specialObjects = Arrays.asList(snake1, snake2, ladder1, ladder2);

        // Create game components
        Board board = new Board(boardSize);
        Dice dice = new Dice();
        DiceStrategy strategy = new RerollOnSixStrategy();
        DiceController diceController = new DiceController(List.of(dice), strategy, specialObjects);
        TurnManager turnManager = new TurnManager();
        GameController gameController = new GameController(board, diceController, turnManager);

        // Start game
        Game game = new Game(gameController, players);
        game.start();
    }
}
