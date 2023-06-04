package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Random random = new Random();
    public Player player = new Player();
    public Room room = new Room();
    public NPC monster = new NPC();
    @FXML
    private Button North;
    @FXML
    private Button South;
    @FXML
    private Button east;
    @FXML
    private Button west;
    @FXML
    private Button Search;
    @FXML
    private Button Sleep;
    @FXML
    private Button run;
    @FXML
    private Button Fight;
    @FXML
    private TextField gameText;
    ArrayList<ArrayList<Room>> maze;
    Room[][] rooms;
    public int playerHit;
    public int monsterHit;
    public int playerStrength;
    public int playerIntelligence;
    public int playerGold;
    public int monsterDext;
    public int monsterStr;
    public int monsterIntell;
    public int playerRow = 5;
    public int playerColumn = 5;
    @FXML
    private Label PlayerAttributes;
    @FXML
    private Label monsterAttributes;

    public HelloController() {
        Random random = new Random();
        Player player = new Player();
        NPC monster = new NPC();


        rooms = new Room[10][10];

        for (int rowIndex = 0; rowIndex < 10; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 10; columnIndex++){
                rooms[rowIndex][columnIndex] = new Room();
            }
        }

        maze = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < 10; rowIndex++){
            maze.add(new ArrayList<>());
            for (int columnIndex = 0; columnIndex < 10; columnIndex++){
                maze.get(rowIndex).add(new Room());
            }
        }
        room = maze.get(5).get(5);
        room = maze.get(playerRow).get(playerColumn);

        playerHit =  player.getHitPoints();
        int playerStrength = player.getStrength();
        int playerIntelligence = player.getIntelligence();
        int playerGold = player.getGold();
        int monsterDext = monster.getDexterity();
        int monsterStr = monster.getStrength();
        int monsterIntell = monster.getIntelligence();
        int monsterHit = monster.getHitPoints();



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Random random = new Random();

        rooms = new Room[10][10];

        for (int rowIndex = 0; rowIndex < 10; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 10; columnIndex++){
                rooms[rowIndex][columnIndex] = new Room();
            }
        }

        maze = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < 10; rowIndex++){
            maze.add(new ArrayList<>());
            for (int columnIndex = 0; columnIndex < 10; columnIndex++){
                maze.get(rowIndex).add(new Room());
            }
        }
         playerHit =  player.getHitPoints();
         playerStrength = player.getStrength();
         playerIntelligence = player.getIntelligence();
         playerGold = player.getGold();
         monsterDext = monster.getDexterity();
         monsterStr = monster.getStrength();
         monsterIntell = monster.getIntelligence();
         monsterHit = monster.getHitPoints();

         PlayerAttributes.setText("PLAYER \t Hit Points: " + playerHit + "\t Gold: " + playerGold + "\t Strength: " + playerStrength + "\t Intelligence: " + playerIntelligence);
         monsterAttributes.setText("MONSTER \t Hit Points: " + monsterHit + "\t Strength: " + monsterStr + "\t Intelligence: " + monsterIntell + " Dexterity: " + monsterDext);

    }

    @FXML
    public void moveNorth(ActionEvent actionEvent) {
        if (playerRow <= 0){
            gameText.setText("You're at the top buddy.");
        }
        else {
            if (maze.get(playerRow-1).get(playerColumn).isBlocked()) {
                gameText.setText("This room is blocked.");

            }
            else {
                gameText.setText("You have went north into a big building that led you into a dark hallway.");
                playerRow -= 1;
            }
        }

    }

    @FXML
    public void moveEast(ActionEvent actionEvent) {
        if (playerColumn >= 10){
            gameText.setText("You're at the right buddy.");
        }
        else {
            if (maze.get(playerRow).get(playerColumn+1).isBlocked()) {
                gameText.setText("This room is blocked.");

            }
            else {
                gameText.setText("You have went east into an an eerie alleyway.");
                playerColumn += 1;
            }
        }

    }

    @FXML
    public void moveWest(ActionEvent actionEvent) {
        if (playerColumn <= 0) {
            gameText.setText("You're at the left buddy.");
        } else {
            if (maze.get(playerRow).get(playerColumn - 1).isBlocked()) {
                gameText.setText("This room is blocked.");

            } else {
                gameText.setText("You have went west into the forest with no clear sight out.");
                playerColumn -= 1;
            }
        }
    }


    @FXML
    public void moveSouth(ActionEvent actionEvent) {
        if (playerRow >= 10){
            gameText.setText("You're at the bottom buddy.");
        }
        else {
            if (maze.get(playerRow+1).get(playerColumn).isBlocked()) {
                gameText.setText("This room is blocked.");

            }
            else {
                gameText.setText("You have went south into the abyss.");
                playerRow += 1;
            }
        }
    }

    @FXML
    public void searchRoom(ActionEvent actionEvent) {
        int dice = random.nextInt(20);
        if (dice <= playerIntelligence){
            gameText.setText("You have rolled a " + dice + "! You have found 20 gold.");
            playerGold += 20;
            PlayerAttributes.setText("PLAYER \t Hit Points: " + playerHit + "\t Gold: " + playerGold + "\t Strength: " + playerStrength + "\t Intelligence: " + playerIntelligence);
        }
        else {
            gameText.setText("You have rolled a " + dice + "! No gold for you!");
        }
        PlayerAttributes.setText("PLAYER \t Hit Points: " + playerHit + "\t Gold: " + playerGold + "\t Strength: " + playerStrength + "\t Intelligence: " + playerIntelligence);
    }

    @FXML
    public void sleep(ActionEvent actionEvent) {
       player.setHitPoints(playerHit);
        gameText.setText("You have slept.");
        player.setHitPoints(20);
        int dice = random.nextInt(6) + 1;
        if (dice == 2) {
            monster = new NPC();
            gameText.setText("A monster has appeared!");
            monsterAttributes.setText("MONSTER \t Hit Points: " + monsterHit + "\t Strength: " + monsterStr + "\t Intelligence: " + monsterIntell + " Dexterity: " + monsterDext);
        }
    }

    @FXML
    public void run(ActionEvent actionEvent) {
        int dice = random.nextInt(20) + 1;
        if (dice < monsterIntell){
            playerStrength -= 3;
            gameText.setText("The monster seen you, you have been attacked.");
            PlayerAttributes.setText("PLAYER \t Hit Points: " + playerHit + "\t Gold: " + playerGold + "\t Strength: " + playerStrength + "\t Intelligence: " + playerIntelligence);
            monsterAttributes.setText("MONSTER \t Hit Points: " + monsterHit + "\t Strength: " + monsterStr + "\t Intelligence: " + monsterIntell + " Dexterity: " + monsterDext);
            moveEast(actionEvent);
        }
        else {
            gameText.setText("You got away!");
            moveSouth(actionEvent);

        }
    }

    @FXML
    public void fight(ActionEvent actionEvent) {
        int dice = random.nextInt(20) + 1;
        if (dice >= monsterDext) {
            monsterAttributes.setText("MONSTER \t Hit Points: " + monsterHit + "\t Strength: " + monsterStr + "\t Intelligence: " + monsterIntell + "Dexterity: " + monsterDext);
            monsterStr -= playerStrength / 3;
            gameText.setText("You hit the monster!");
            player.hitPoints -= 1;
            PlayerAttributes.setText("PLAYER \t Hit Points: " + playerHit + "\t Gold: " + playerGold + "\t Strength: " + playerStrength + "\t Intelligence: " + playerIntelligence);
            monsterAttributes.setText("MONSTER \t Hit Points: " + monsterHit + "\t Strength: " + monsterStr + "\t Intelligence: " + monsterIntell + " Dexterity: " + monsterDext);
            if (monster.strength > 0){
                playerStrength -= monsterStr / 3;
                gameText.setText("You have been attacked!");
                PlayerAttributes.setText("PLAYER \t Hit Points: " + playerHit + "\t Gold: " + playerGold + "\t Strength: " + playerStrength + "\t Intelligence: " + playerIntelligence);
                monsterAttributes.setText("MONSTER \t Hit Points: " + monsterHit + "\t Strength: " + monsterStr + "\t Intelligence: " + monsterIntell + " Dexterity: " + monsterDext);
            }

        }
        else {
            gameText.setText("You didn't hit the monster.");
            monsterAttributes.setText("MONSTER \t Hit Points: " + monsterHit + "\t Strength: " + monsterStr + "\t Intelligence: " + monsterIntell + " Dexterity: " + monsterDext);
        }
    }

}