package examples.snakeladder.myimpl;
public class Player {
    private String name;
    private Position currentPosition;
    private boolean hasWon;

    public Player(String name, Position startPos) {
        this.name = name;
        this.currentPosition = startPos;
        this.hasWon = false;
    }

    public String getName() {
        return name;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position pos) {
        this.currentPosition = pos;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }
}