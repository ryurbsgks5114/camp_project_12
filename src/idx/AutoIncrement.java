package idx;

public class AutoIncrement {

    private int idx;

    public AutoIncrement() {
        this.idx = 0;
    }

    public int getIdx() {
        return idx;
    }

    public void increase() {
        this.idx++;
    }

}
