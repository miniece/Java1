import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("This program will contractors build a deck!");

        System.out.println("What is the length of the deck?");
        double deckLength = Double.parseDouble(keyboard.nextLine());

        System.out.println("What is the width of the deck?");
        double deckWidth = Double.parseDouble(keyboard.nextLine());

        System.out.println("What is the length of the board you are buying?");
        double boardLength = Double.parseDouble(keyboard.nextLine());

        System.out.println("What is the width of the board you are buying?");
        double boardWidth = Double.parseDouble(keyboard.nextLine());

        double deckArea = deckLength * deckWidth;
        double boardArea = boardLength * boardWidth;
        double boardsRequired = Math.ceil(deckArea / boardArea);

        System.out.println("What is the cost per board?");
        double costPerBoard = Double.parseDouble(keyboard.nextLine());

        double totalBoardCost = boardsRequired * costPerBoard;

        if (totalBoardCost >= 1000 && totalBoardCost < 2000) {
            //below is amount you're saving
            double tenDiscount = totalBoardCost * .10;
            totalBoardCost -= tenDiscount;
        } else if (totalBoardCost >= 2000) {
            double twentyDiscount = totalBoardCost * .20;
            totalBoardCost -= twentyDiscount;
        }

        System.out.println("What is the estimated time in hours that this project will take?");
        double timeEstimate = Double.parseDouble(keyboard.nextLine());

        System.out.println("How much do you charge per hour?");
        double costPerHour = Double.parseDouble(keyboard.nextLine());

        double totalLaborCost = timeEstimate * costPerHour;

        System.out.println("Does this custom get a discount? Please enter y/n");
        var answer = keyboard.nextLine();

        if (answer.equals("y")) {
            System.out.println("What is the discount percent?");
            double discountPercent = Double.parseDouble(keyboard.nextLine());
            double discAmount = totalLaborCost * (discountPercent / 100);
            double overallDiscCost = totalBoardCost + (totalLaborCost - discAmount);
            System.out.println("Your total is $" + Math.ceil(overallDiscCost));
            }

        else if (answer.equals("n")) {
            double overallCost = totalBoardCost + totalLaborCost;
            System.out.println("Your total is $" + Math.ceil(overallCost));
            }
    }
}