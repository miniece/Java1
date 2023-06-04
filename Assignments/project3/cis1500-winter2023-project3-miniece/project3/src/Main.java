import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the shop.");
        System.out.println("To exit out of program at any time, type 'exit'.");

        getMode();


    }

    public static void getMode() throws IOException {
        var choice = "";

        System.out.println("What would you like to do? Please type 'manage' or 'kiosk'.");
        choice = keyboard.nextLine();

        if (choice.equalsIgnoreCase("manage")) {
            manageShop();
        }
        else if (choice.equalsIgnoreCase("kiosk")){
            kioskMode();
        }
    }

    public static void kioskMode() throws IOException {
        var itemName = "";
        double moneyAvailable = 0;
        double price = 0;
        double quantity = 0;
        double purchasingAmount = 0;
        double totalCost = 0;
        ShoppingCart cart = new ShoppingCart();
        boolean cont = true;

        File itemsFolder = new File("logs/");
        Scanner items = new Scanner(itemsFolder);

        System.out.println("How much money do you have to spend?");
        moneyAvailable = Double.parseDouble(keyboard.nextLine());

        while (cont = true) {


            System.out.println("Please input the name of the item you wish to purchase.");
            itemName = keyboard.nextLine();


            if (!itemsFolder.exists()) {
                System.out.println("Sorry, you can't buy that.");
            } else {
                System.out.println("Great, that item is $" + price + " and there are " + quantity + " available to purchase.");
                System.out.println("");
                System.out.println("How many would you like to buy?");
                purchasingAmount = Double.parseDouble(keyboard.nextLine());
                totalCost = price * purchasingAmount;
                if (totalCost > moneyAvailable) {
                    System.out.println("You don't have enough money.");
                    continue;
                }
            }
            moneyAvailable -= totalCost;
            quantity -= purchasingAmount;

            cart.addItem(itemName, purchasingAmount, totalCost);

            System.out.println("Do you want to continue shopping? (y/n)");
            String answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                cont = true;
            }
            else {
                System.out.println("Here is your receipt: " + itemName + "//" + quantity + "//" + price);
            }
        }
    }

    public static void updateShop() throws IOException {
        var itemName = "";
        double quantity = 0;
        double price = 0;

        System.out.println("Please enter the item you would like to update.");
        itemName = keyboard. nextLine();

        File logDirectory = new File("logs");
        logDirectory.mkdirs();

        PrintWriter printWriter = new PrintWriter(new FileWriter("logs/" + itemName + ".txt"), true);


        File itemFile = new File("logs/" + itemName + ".txt");
        Item item;



        if (!itemFile.exists()) {
            System.out.println("This item does not exist, please go add the item. Switching you over now.");
            manageShop();
        }
        else {
            System.out.println("Updating item file.");

            System.out.println("Enter the new quantity of the item.");
            quantity = Double.parseDouble(keyboard.nextLine());
            printWriter.println(quantity);

            System.out.println("Enter the new price of the item.");
            price = Double.parseDouble(keyboard.nextLine());
            printWriter.println(price);

            item = new Item(itemName, quantity, price);

        }
        printWriter.close();
    }

    public static void manageShop() throws IOException {
        var itemName = "";
        double quantity = 0;
        double price = 0;
        boolean cont = true;

        while (cont = true) {


            File logDirectory = new File("logs");
            logDirectory.mkdirs();


            System.out.println("Please enter the item the name of your item.");
            itemName = keyboard.nextLine();

            PrintWriter printWriter = new PrintWriter(new FileWriter("logs/" + itemName + ".txt"), true);

            File itemFile = new File(itemName);

            System.out.println("If you would like to delete the item, simply type, 'delete', otherwise press any key to continue.");
            var del = keyboard.nextLine();


            Item item;
            if (del.equalsIgnoreCase("delete")) {
                itemFile.delete();
            } else if (itemFile.exists()) {
                System.out.println("This item already exists, switching you over to the update option.");
                updateShop();
            }
            else {
                System.out.println("Adding item file.");

                System.out.println("Enter the quantity of the item.");
                quantity = Double.parseDouble(keyboard.nextLine());
                printWriter.println(quantity);


                System.out.println("Enter the price of the item.");
                price = Double.parseDouble(keyboard.nextLine());
                printWriter.println(price);

                item = new Item(itemName, quantity, price);

                //item.writeToFile(); - confused about this
            }
            printWriter.close();
        }
    }
}