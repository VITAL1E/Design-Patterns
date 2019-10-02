// FACTORY DESIGN PATTERN

public abstract class Cake {
    public abstract double getCost();

    public String toString() {
        return "Cost: " + this.getCost();
    }
}

class Cheesecake extends Cake {
    private double cost;

    Cheesecake(double cost) {
        this.cost = cost;
    }
    public double getCost() {
        return this.cost;
    }
}

class ChocolateCake extends Cake {
    private double cost;

    ChocolateCake(double cost) {
        this.cost = cost;
    }
    public double getCost() {
        return this.cost;
    }
}

class PastryFactory {
    public static Cake getInstance(String type, double cost) {
        if (type.equals("cheesecake")) {
            return new Cheesecake(cost);
        } else if (type.equals("chocolate cake")) {
            return new ChocolateCake(cost);
        }
        return null;
    }
}

