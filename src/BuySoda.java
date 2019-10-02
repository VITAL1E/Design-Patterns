// NULL OBJECT DESIGN PATTERN

public class BuySoda {

    public static Soda getSoda(boolean isAvailable) {
        if (isAvailable) return new CocaCola();
        else return new NoSoda();
    }
}

interface Soda {
    void getCost();
}

class CocaCola implements Soda {

    public void getCost() {
        System.out.println("Cost of soda");
    }
}

class NoSoda implements Soda {

    public void getCost() {  }
}
