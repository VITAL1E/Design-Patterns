import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static void printInfo(Coffee coffee) {
        System.out.println("Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getIngredients());
    }

    public static void main(String[] args) throws InterruptedException {
        double price = 0;

        while (true) {
            System.out.println("===== WELCOME TO THE CANDY SHOP =====");
            System.out.println("=====            MENU           =====");
            System.out.println("1. Cake");
            System.out.println("2. Coffee");
            System.out.println("3. Chocolate bar");
            System.out.println("4. Doughnut");
            System.out.println("5. Soda");
            System.out.println("6. Finish order");

            Scanner scanner = new Scanner(System.in);

            int option = scanner.nextInt();

            if (option == 1) {

                String answer = null;

                while (true) {
                    System.out.println("=====       Cake Types       =====");
                    System.out.println("1. Cheesecake........ 4$");
                    System.out.println("2. Chocolate cake.... 2$");

                    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                    try {
                        answer = input.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (answer.equals("1")) {

                        System.out.println("You chose cheesecake");
                        Cake cheesecake = PastryFactory.getInstance("cheesecake", 4);

                        price += cheesecake.getCost();
                        System.out.println(cheesecake);
                        Thread.sleep(1500);
                        break;

                    } else if (answer.equals("2")) {

                        System.out.println("You chose chocolate cake");
                        Cake chocolateCake = PastryFactory.getInstance("chocolate cake", 2);

                        price += chocolateCake.getCost();
                        System.out.println(chocolateCake);
                        Thread.sleep(1500);
                        break;

                    } else {
                        System.out.println("Please choose valid option");
                    }
                }
                System.out.println(" ");
            } else if (option == 2) {

                Scanner scanCoffee = new Scanner(System.in);

                for (int i = 0; i < 1; i++) {

                    System.out.println("=====       Coffee Types       =====");
                    System.out.println("1. Simple Coffee............. 1$");
                    System.out.println("2. Coffee with milk........ 1.5$");
                    System.out.println("3. Coffee with sprinkles... 1.2$");

                    int coffeeOption = scanCoffee.nextInt();
                    Coffee coffee = new SimpleCoffee();

                    if (coffeeOption == 1) {
                        printInfo(coffee);

                        price += coffee.getCost();
                        System.out.println("You chose simple coffee");
                        Thread.sleep(1500);

                    } else if (coffeeOption == 2) {

                        Coffee withMilk = new WithMilk(coffee);
                        price += withMilk.getCost();

                        printInfo(withMilk);
                        System.out.println("You chose coffee with milk");
                        Thread.sleep(1500);

                    } else if (coffeeOption == 3) {

                        Coffee withSprinkles = new WithSprinkles(coffee);
                        price += withSprinkles.getCost();

                        printInfo(withSprinkles);
                        System.out.println("You chose coffee with sprinkles");
                        Thread.sleep(1500);

                    } else {
                        System.out.println("Please choose an option");
                    }
                }
            } else if (option == 3) {
                Scanner chocolate = new Scanner(System.in);

                try {
                    System.out.println("We have only one snickers left");
                    Thread.sleep(1500);
                    System.out.println("It costs only 0.6$");
                    Thread.sleep(1500);

                    System.out.println("Would you like to buy it? (y / n)");

                    String scanChocolate = chocolate.nextLine();

                    if (scanChocolate.equals("y")) {
                        Snickers snickers = Snickers.getInstance();

                        price += snickers.getCost();

                        System.out.println("Good choice. You got our last snickers");
                        Thread.sleep(1500);

                    } else if (scanChocolate.equals("n")) {

                        System.out.println("Alright. No chocolate");
                        Thread.sleep(1500);

                    } else {
                        System.out.println("Please choose a valid option");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (option == 4) {
                while (true) {
                    System.out.println("===            DOUGHNUT TYPES           ===");
                    System.out.println("1. Vanilla doughnut with ice-cream.... 2.5$");
                    System.out.println("2. Chocolate doughnut................. 1.9$");
                    System.out.println("3. Cinnamon........................... 1.2$");

                    Scanner doughnutScanner = new Scanner(System.in);
                    int doughnutOption = doughnutScanner.nextInt();

                    if (doughnutOption == 1) {
                        Doughnut vanillaDoughnut = new Doughnut.Builder("vanilla", 2.5).setCream("ice-cream").build();
                        System.out.println("You chose vanilla doughnut with ice-cream. Ingredients: " + vanillaDoughnut.getFlavour() + ", " + vanillaDoughnut.getCream());
                        price += vanillaDoughnut.getCost();
                        break;

                    } else if (doughnutOption == 2) {
                        Doughnut chocolateDoughnut = new Doughnut.Builder("chocolate", 1.9).build();
                        System.out.println("You chose chocolate doughnut. Ingredients: " + chocolateDoughnut.getFlavour());
                        price += chocolateDoughnut.getCost();
                        break;

                    } else if (doughnutOption == 3) {
                        Doughnut cinnamon = new Doughnut.Builder("cinnamon", 1.2).build();
                        System.out.println("You chose cinammon. Ingredients: " + cinnamon.getFlavour());
                        price += cinnamon.getCost();
                        break;

                    } else {
                        System.out.println("Please choose a valid option");
                    }
                }

            } else if (option == 5) {
                Soda soda = NullObjectPattern.getSoda(false);
                soda.getCost();
                System.out.println("We do not sell soda anymore :(");
                Thread.sleep(1500);

            } else if (option == 6) {
                System.out.println("BON APPETIT");
                break;

            } else {
                System.out.println("Please choose valid option");
            }

        }
        System.out.println("Your order costs " + price + "$");
    }
}
