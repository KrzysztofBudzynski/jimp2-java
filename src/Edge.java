public class Edge {
    private final Punkt from;
    private final Punkt to;
    private double waga;

    public Edge(Punkt a, Punkt b) {
        this.from = a;
        this.to = b;
    }

    public Edge() {
        this.from = null;
        this.to = null;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public Punkt getTo() {
        return to;
    }

    public double getWaga() {
        return waga;
    }

    public Punkt getFrom() {
        return from;
    }
}
