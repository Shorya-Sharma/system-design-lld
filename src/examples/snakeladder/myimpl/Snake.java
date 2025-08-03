package examples.snakeladder.myimpl;
public class Snake extends SpecialObject {
    public Snake(Position start, Position end) {
        super(start, end);
    }

    @Override
    public Position move(Position currPos) {
        return currPos.equals(start) ? end : currPos;
    }
}