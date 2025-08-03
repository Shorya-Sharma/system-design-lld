package examples.snakeladder.myimpl;
import java.util.List;

public class Game {
    private GameController controller;
    private List<Player> players;

    public Game(GameController controller, List<Player> players) {
        this.controller = controller;
        this.players = players;
        for (Player p : players) {
            controller.turnManager.addPlayer(p);
        }
    }

    public void start() {
        controller.startGame();
    }
}