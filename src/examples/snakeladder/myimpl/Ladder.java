package examples.snakeladder.myimpl;
public class Ladder extends SpecialObject {
    public Ladder(Position start, Position end) {
        super(start, end);
    }

    @Override
    public Position move(Position currPos) {
        return currPos.equals(start) ? end : currPos;
    }
}