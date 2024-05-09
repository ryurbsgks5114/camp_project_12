package idx;

public class AutoIncrement {

    private int idx;

    public AutoIncrement() {
        this.idx = 1;
    }

    public int getIdx() {
        return idx;
    }

    public void increase() {
        this.idx++;
    }

}
