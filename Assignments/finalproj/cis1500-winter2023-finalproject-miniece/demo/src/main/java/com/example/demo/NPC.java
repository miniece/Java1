package com.example.demo;

import java.util.Random;

public class NPC {
    Random randomNum = new Random();

    public int hitPoints;

    public int strength;

    public int dexterity;

    public int intelligence;



    public NPC() {
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints() {


        hitPoints = randomNum.nextInt(6) * 2;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength() {

        strength = randomNum.nextInt(6) * 2;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity() {

        dexterity = randomNum.nextInt(6) * 2;;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence() {

        intelligence = randomNum.nextInt(6) * 2;
    }
}
