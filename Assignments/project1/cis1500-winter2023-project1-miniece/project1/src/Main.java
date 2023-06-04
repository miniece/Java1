import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
public static int turnsTaken = 1;
    public static void main(String[] args) {
        System.out.println("Welcome to the text based adventure game.");
        getTravelDirection();
        getActionChoice();

    }

    public static String getActionChoice() {
        Scanner keyboard = new Scanner(System.in);

        var playerAction = "";

        System.out.println("Which actions would you like to take? Type attack, sleep, roam, or acquire");
        playerAction = keyboard.nextLine();


        if (playerAction.equalsIgnoreCase("sleep")) {
            turnsTaken++;
            displaySleepAction();

        }
        else if (playerAction.equalsIgnoreCase("help")) {
            turnsTaken++;
            escapeWord(turnsTaken);
        }
        else if(playerAction.equalsIgnoreCase("attack")) {
            turnsTaken++;
            displayAttackAction();
        }
        else if (playerAction.equalsIgnoreCase("roam")){
            turnsTaken++;
            displayRoamAction();
        }
        else if (playerAction.equalsIgnoreCase("acquire")){
            turnsTaken++;
            displayAcquireAction();
        }


        while (!playerAction.equalsIgnoreCase("sleep") && !playerAction.equalsIgnoreCase("attack") && !playerAction.equalsIgnoreCase("roam") && !playerAction.equalsIgnoreCase("acquire") && !playerAction.equalsIgnoreCase("help")) {
            System.out.println("Not a valid response. Try typing sleep, attack, roam, or acquire.");
            playerAction = keyboard.nextLine();
            if (playerAction.equalsIgnoreCase("sleep")) {
                turnsTaken++;
                displaySleepAction();

            }
            else if (playerAction.equalsIgnoreCase("help")) {
                turnsTaken++;
                escapeWord(turnsTaken);
            }
            else if(playerAction.equalsIgnoreCase("attack")) {
                turnsTaken++;
                displayAttackAction();
            }
            else if (playerAction.equalsIgnoreCase("roam")){
                turnsTaken++;
                displayRoamAction();
            }
            else if (playerAction.equalsIgnoreCase("acquire")){
                turnsTaken++;
                displayAcquireAction();
            }
        }
        return playerAction;
        }

    private static void displayAcquireAction() {
        System.out.println("While on your journey, you have found an item. You have acquired it. It's useless, but it's still nice that you found something on your travels.");
        getTravelDirection();
        getActionChoice();
    }

    private static void displayRoamAction() {
        System.out.println("While roaming, you have seen a large monster! You have attacked but you have also taken a good amount of damage. You must go heal.");
        displaySleepAction();
    }

    private static void displayAttackAction() {
        System.out.println("You have encountered a foul beast! Luckily, they are no match for you and your enemy is slain. Congrats!");
        getTravelDirection();
        getActionChoice();
    }


    public static void displaySleepAction() {
        System.out.println("You are sleep. While you are sleeping, you are also healing. You are not able to travel at this time.");
        getActionChoice();
    }

    public static String getTravelDirection() {
        Scanner keyboard = new Scanner(System.in);

        var playerTravel = "";

        System.out.println("Which direction would you like to travel? Type east, west, north, or south. ");
        playerTravel = keyboard.nextLine();

        if (playerTravel.equalsIgnoreCase("east")) {
            travelEast();
        } else if (playerTravel.equalsIgnoreCase("west")) {
            travelWest();
        } else if (playerTravel.equalsIgnoreCase("north")) {
            travelNorth();
        } else if (playerTravel.equalsIgnoreCase("south")) {
            travelSouth();
        }

        if (playerTravel.equalsIgnoreCase("help")) {
            escapeWord(turnsTaken);
        }

        while (!playerTravel.equalsIgnoreCase("east") && !playerTravel.equalsIgnoreCase("west") && !playerTravel.equalsIgnoreCase("north") && !playerTravel.equalsIgnoreCase("south") && !playerTravel.equalsIgnoreCase("help")) {
            System.out.println("Not a valid response. Try typing east, west, north, or south.");
            playerTravel = keyboard.nextLine();
            if (playerTravel.equalsIgnoreCase("help")) {
                escapeWord(turnsTaken);
            }
            else if (playerTravel.equalsIgnoreCase("east")) {
                travelEast();
            } else if (playerTravel.equalsIgnoreCase("west")) {
                travelWest();
            } else if (playerTravel.equalsIgnoreCase("north")) {
                travelNorth();
            } else if (playerTravel.equalsIgnoreCase("south")) {
                travelSouth();
            }
        }

        return playerTravel;
    }

    private static void travelSouth() {
        System.out.println("You have traveled south into a nearby cave.");
        getActionChoice();
    }

    private static void travelNorth() {
        System.out.println("You have traveled north to the mountain top");
        getActionChoice();
    }

    private static void travelWest() {
        System.out.println("You have traveled west into a nearby village.");
        getActionChoice();
    }

    private static void travelEast() {
        System.out.println("You have traveled east into a forest.");
        getActionChoice();
    }

    public static void escapeWord(int turnsTaken) {
        System.out.println("You have found the secret escape word.");
        System.out.println("You have wasted " + turnsTaken + " turns.");
        System.exit(0);
    }
}