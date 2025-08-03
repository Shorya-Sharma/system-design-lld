package examples.snakeladder.myimpl;
public class Position {
    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int toIndex(int size) {
        return row * size + col;
    }

    public static Position fromIndex(int index, int size) {
        return new Position(index / size, index % size);
    }

    public boolean equals(Position other) {
        return this.row == other.row && this.col == other.col;
    }
}