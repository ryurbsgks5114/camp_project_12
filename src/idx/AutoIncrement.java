package idx;

public class AutoIncrement {

    private int idx;

    public AutoIncrement() {
        this.idx = 0;
    }

    public int increase() {
        return this.idx++;
    }

}
