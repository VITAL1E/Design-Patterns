// BUILDER DESIGN PATTERN

public class Doughnut {
    private String flavour, cream;
    private double cost;

    public String getFlavour() {
        return this.flavour;
    }

    public double getCost() {
        return this.cost;
    }

    public String getCream() {
        return this.cream;
    }

    private Doughnut(Builder builder) {
        this.flavour = builder.flavour;
        this.cost = builder.cost;
        this.cream = builder.cream;
    }

    public static class Builder {
        private String flavour, cream;
        private double cost;

        public Builder(String flavour, double cost) {
            this.flavour = flavour;
            this.cost = cost;
        }

        public Builder setCream(String cream) {
            this.cream = cream;
            return this;
        }

        public Doughnut build() {
            return new Doughnut(this);
        }
    }
}

