import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double score = 0;
        double count = 0;
        double sum = 0;
        double average;

        System.out.println("Welcome! This program will take your scores and give you the average!");
        System.out.println("Please enter the test score, or press 0 to calculate the scores.");
        score = Double.parseDouble(keyboard.nextLine());

        while (score != 0) {
            sum += score;
            count++;
            System.out.println("Please enter the test score, or press 0 to calculate the scores.");
            score = Double.parseDouble(keyboard.nextLine());
            }

        if (score == 0){
            average = sum / count;
            System.out.println("Here are the average of these scores: " + average);
        }

    }
    }