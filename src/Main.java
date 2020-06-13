import java.util.Scanner;
public class Main {
    public static int earnings = 550;
    public static int mlOfWatter = 400;
    public static int mlOfMilk = 540;
    public static int gOfCoffee = 120;
    public static int disposableCaps = 9;

    public static void printStats() {
        System.out.println("The coffee machine has:\n" +
                mlOfWatter +  " of water\n" +
                mlOfMilk + " of milk\n" +
                gOfCoffee + " of coffee beans\n" +
                disposableCaps + " of disposable cups\n" +
                earnings + " of money");
    }
    public static String takeChoice(String possibilities) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(possibilities);
        return scanner.next();
    }
    public static boolean checkTheStock(String choice) {
        if (disposableCaps < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        switch (choice) {
            case "1":
                if (mlOfWatter < 250) {
                    System.out.println("Sorry, not enough disposable watter!");
                } else if (gOfCoffee < 16){
                    System.out.println("Sorry, not enough coffee!");
                }
                return (mlOfWatter >= 250 && gOfCoffee >= 16);
            case "2":
                if (mlOfWatter < 350) {
                    System.out.println("Sorry, not enough disposable watter!");
                } else if (gOfCoffee < 20){
                    System.out.println("Sorry, not enough coffee!");
                } else if (mlOfMilk < 75){
                    System.out.println("Sorry, not enough milk");
                }
                return (mlOfWatter >= 350 && mlOfMilk >= 75 && gOfCoffee >= 20);
            case "3":
                if (mlOfWatter < 250) {
                    System.out.println("Sorry, not enough disposable watter!");
                } else if (gOfCoffee < 16){
                    System.out.println("Sorry, not enough coffee!");
                } else if (mlOfMilk < 100){
                    System.out.println("Sorry, not enough milk");
                }
                return (mlOfWatter >= 200 && mlOfMilk >= 100 && gOfCoffee >= 12);
            default:
                return false;
        }


    }
    public static void makeCoffee() {
        String choice = takeChoice("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (choice) {
            case "1":
                if (checkTheStock(choice)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    mlOfWatter -= 250;
                    gOfCoffee -= 16;
                    earnings += 4;
                    disposableCaps -=1;
                    break;
                } else {
                    break;
                }

            case "2":
                if (checkTheStock(choice)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    mlOfWatter -= 350;
                    mlOfMilk -= 75;
                    gOfCoffee -= 20;
                    earnings += 7;
                    disposableCaps -=1;
                    break;
                } else {
                    break;
                }
            case "3":
                if (checkTheStock(choice)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    mlOfWatter -= 200;
                    mlOfMilk -= 100;
                    gOfCoffee -= 12;
                    earnings += 6;
                    disposableCaps -=1;
                    break;
                } else {
                    break;
                }
            case "back":
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }

    }
    public static void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        mlOfWatter += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        mlOfMilk +=  scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        gOfCoffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCaps += scanner.nextInt();
    }
    public static void takeMoney() {
        System.out.println("I gave you $" + earnings);
        earnings = 0;
    }

    public static void main(String[] args) {
        //printStats();
        String actionChoice = "";
        while (!actionChoice.equals("exit")){
            actionChoice = takeChoice("Write action (buy, fill, take, remaining, exit):");
            switch (actionChoice) {
                case "buy":
                    makeCoffee();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printStats();
                    break;
                case "exit" :
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }

        }


    }
}



