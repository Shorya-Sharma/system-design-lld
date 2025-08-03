package examples.snakeladder.myimpl;
public abstract class SpecialObject {
    protected Position start;
    protected Position end;

    public SpecialObject(Position start, Position end) {
        this.start = start;
        this.end = end;
    }

    public abstract Position move(Position currPos);
}