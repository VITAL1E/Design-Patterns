// SINGLETON DESIGN PATTERN

public final class Snickers {

    private static double cost = 0.6;

    private static final Snickers INSTANCE = new Snickers();

    private Snickers() {}

    public static Snickers getInstance() {
        return INSTANCE;
    }

    public double getCost() {
        return cost;
    }
}
