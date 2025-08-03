package examples.snakeladder.myimpl;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // equals and hashCode methods if needed for comparisons or hash maps
}
