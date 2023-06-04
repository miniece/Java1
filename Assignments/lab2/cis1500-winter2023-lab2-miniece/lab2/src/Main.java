import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello, we're going to make sure theres enough pizza for everyone!");

        System.out.println("How many friends are coming to the party?");
        double friendsComing = Double.parseDouble(keyboard.nextLine());

        System.out.println("How many slices of pizza does your friends eat on average?");
        double avgSlicesEaten = Double.parseDouble(keyboard.nextLine());

        System.out.println("How many slices are in each pizza?");
        double slicesPerWhole = Double.parseDouble(keyboard.nextLine());

        System.out.println("How many pizzas are you buying?");
        double initialBoxes = Double.parseDouble(keyboard.nextLine());

        double slicesRequired = avgSlicesEaten * friendsComing;
        double boxesRequired = Math.ceil(slicesRequired / slicesPerWhole);

        if (initialBoxes < boxesRequired){
            System.out.println("According to my calculations, you're actually going to need " + boxesRequired + "boxes of pizza.");
        }
        else {
            System.out.println("It looks like you've already planned on bringing enough, you're so smart!");
        }

    }
}