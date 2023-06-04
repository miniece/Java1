import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ROCK PAPER SCISSORS

        String playersThrow = getPlayersThrow();
        String computersThrow = getComputersThrow();
        displayCountDownAndWinner(playersThrow, computersThrow);
    }

    private static void displayCountDownAndWinner(
            String playersThrow, String computersThrow) {
        System.out.println("Rock");
        System.out.println("Paper");
        System.out.println("Scissors");
        System.out.println("Shoot!");

        // TODO - fix this
        System.out.println("Player picked: " + playersThrow);
        System.out.println("Computer picked: " + computersThrow);

        if (playersThrow.equals(computersThrow)){
            System.out.println("It's a tie!");
        }
        else if (playersThrow.equals("Rock") && computersThrow.equals("Scissors") ||
        playersThrow.equals("Scissors") && computersThrow.equals("Paper") ||
        playersThrow.equals("Paper") && computersThrow.equals("Rock")) {
            System.out.println("You won!");
        }
        else{
            System.out.println("You lost!");
        }

    }

    private static String getComputersThrow() {
        // TODO - DO THIS
        Random random = new Random();

        random.nextInt(1, 4); // gives 1-3
        // Math.random() * (upper bound exclusive - lowerbound) + lower bound
        int number1to3 = (int)(Math.random() * 3) + 1;

        if ( number1to3 == 1 ){
            return "Rock";
        }

        else if (number1to3 == 2) {
            return "Paper";
        }
        else if (number1to3 == 3){

        }
            return "Scissors";

    }

    private static String getPlayersThrow() {
        // TODO - DO THIS
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter 1-3, respectively, for rock, paper, or scissors.");
        double playersMove = Double.parseDouble(keyboard.nextLine());

        if ( playersMove == 1 ){
            return "Rock";
        }

        else if (playersMove == 2) {
            return "Paper";
        }
        else if (playersMove == 3){
            return "Scissors";
        }
        return "Scissors";
    }
}