import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the College Calculator. We will calculate cost and semesters needed to complete your degree.");

        System.out.println("Please enter the number of credits that you have completed.");
        double creditsCompleted = parseDouble(keyboard.nextLine());

        System.out.println("Please enter the number of credits required for your degree.");
        double creditsRequired = parseDouble(keyboard.nextLine());

        System.out.println("How many credits on average do you take per semester?");
        double averageCreditPerSemester = parseDouble(keyboard.nextLine());

        System.out.println("What is the cost per credit?");
        double costPerCredit = parseDouble(keyboard.nextLine());

        double remainingSemesters = ( (creditsRequired - creditsCompleted) / averageCreditPerSemester);
        double estimatedCost = (creditsRequired * costPerCredit);

        System.out.println("You have about " + Math.ceil(remainingSemesters) + " semesters left to complete your degree.");
        System.out.println("It will cost you about $" + estimatedCost);

    }
}