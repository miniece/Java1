import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the shop.");

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

    public static void kioskMode() {
        var itemName = "";
        double moneyAvailable = 0;
        double price = 0;
        double quantity = 0;
        double purchasingAmount = 0;

        System.out.println("How much money do you have to spend?");
        moneyAvailable = Double.parseDouble(keyboard.nextLine());

        System.out.println("Please input the name of the item you wish to purchase.");
        itemName = keyboard.nextLine();

        File itemFile = new File(itemName + ".txt");
        Item item;

        if (!itemFile.exists()) {
            System.out.println("Sorry, you can't buy that.");
        }
        else {
            System.out.println("Great, that item is $" + price + " and there are " + quantity + " available to purchase.");
            System.out.println("");
            System.out.println("How many would you like to buy?");
            purchasingAmount = Double.parseDouble(keyboard.nextLine());

        }
    }

    public static void updateShop() throws IOException {
        var itemName = "";
        double quantity = 0;
        double price = 0;

        System.out.println("Please enter the item you would like to update.");
        itemName = keyboard. nextLine();

        File itemFile = new File(itemName + ".txt");
        Item item;

        if (!itemFile.exists()) {
            System.out.println("This item does not exist, please go add the item. Switching you over now.");
            manageShop();
        }
        else {
            System.out.println("Updating item file.");

            System.out.println("Enter the new quantity of the item.");
            quantity = Double.parseDouble(keyboard.nextLine());

            System.out.println("Enter the new price of the item.");
            price = Double.parseDouble(keyboard.nextLine());

            item = new Item(itemName, quantity, price);

        }
    }

    public static void manageShop() throws IOException {
        var itemName = "";
        double quantity = 0;
        double price = 0;

        System.out.println("Please enter the item the name of your item.");
        itemName = keyboard. nextLine();

        File itemFile = new File(itemName + ".txt");
        Item item;

        if (itemFile.exists()) {
            System.out.println("This item already exists, switching you over to the update option.");
            updateShop();
        }
        else{
            System.out.println("Creating new item file, adding new item.");

            System.out.println("Enter the quantity of the item.");
            quantity = Double.parseDouble(keyboard.nextLine());

            System.out.println("Enter the price of the item.");
            price = Double.parseDouble(keyboard.nextLine());

            item = new Item(itemName, quantity, price);

            //item.writeToFile(); - confused about this
        }
    }
}