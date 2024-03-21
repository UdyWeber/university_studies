public abstract class Peca {
    private int i, j;
    private boolean visited;

    public Peca(int i, int j) {
        this.i = i;
        this.j = j;
        this.visited = false;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
