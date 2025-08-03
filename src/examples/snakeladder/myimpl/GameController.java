package examples.snakeladder.myimpl;
import java.util.List;

public class GameController {
    private Board board;
    private DiceController diceController;
    TurnManager turnManager;
    private GameStatus status = GameStatus.ACTIVE;

    public GameController(Board board, DiceController diceController, TurnManager turnManager) {
        this.board = board;
        this.diceController = diceController;
        this.turnManager = turnManager;
    }

    public void startGame() {
        int size = board.getSize();
        while (status == GameStatus.ACTIVE) {
            Player player = turnManager.getNextPlayer();
            int move = diceController.roll();
            int index = player.getCurrentPosition().toIndex(size) + move;
            if (index >= size * size - 1) {
                player.setHasWon(true);
                System.out.println(player.getName() + " has won!");
                status = GameStatus.FINISHED;
                break;
            }
            Position newPos = Position.fromIndex(index, size);
            newPos = diceController.adjustPosition(newPos);
            player.setCurrentPosition(newPos);
            System.out.println(player.getName() + " moved to " + newPos.toIndex(size));
        }
    }
}