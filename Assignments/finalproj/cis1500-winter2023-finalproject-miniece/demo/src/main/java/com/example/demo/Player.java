package com.example.demo;

import java.util.Random;

public class Player {
    Random random = new Random();
    public int hitPoints;

    public int strength;

    public int dexterity;

    public int intelligence;

    public int gold;

    public Player() {
        this.hitPoints = 20;
        this.strength = 0;
        this.dexterity = 0;
        this.intelligence = 0;
        this.gold = 0;
    }


    public int getHitPoints() {

        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {

        hitPoints = 20;
    }

    public int getStrength() {

        return strength;
    }

    public void setStrength() {

        strength = random.nextInt(6)+1 + random.nextInt(6)+1 + random.nextInt(6)+1;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity() {

        dexterity = random.nextInt(6) + random.nextInt(6) + random.nextInt(6);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence() {

        intelligence = random.nextInt(1, 6) + random.nextInt(1,6) + random.nextInt(1,6);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
