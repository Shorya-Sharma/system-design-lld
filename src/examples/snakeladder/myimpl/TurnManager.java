package examples.snakeladder.myimpl;
import java.util.ArrayDeque;
import java.util.Deque;

public class TurnManager {
    private Deque<Player> players = new ArrayDeque<>();
    private boolean isReversed = false;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getNextPlayer() {
        Player next = players.pollFirst();
        players.addLast(next);
        return next;
    }

    public void skipNextPlayer() {
        players.pollFirst();
    }

    public void reverseOrder() {
        isReversed = !isReversed;
        ArrayDeque<Player> reversed = new ArrayDeque<>();
        players.descendingIterator().forEachRemaining(reversed::add);
        players = reversed;
    }
}