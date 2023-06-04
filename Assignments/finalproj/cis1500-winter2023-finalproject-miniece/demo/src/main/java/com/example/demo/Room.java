package com.example.demo;

import java.util.Random;

public class Room {
    public int gold;
    public boolean blocked;
    public NPC monster;
    public Random random = new Random();

    public Room() {

        int random2 = random.nextInt(10);
        if (random2 < 3) {
            blocked = true;
        }
        else {
            blocked = false;
            int random1 = random.nextInt(2);
            if (random1 == 0) {
                monster = null;
            }
            else {
                monster = new NPC();
            }
        }
    }

    public boolean isBlocked() {
        return blocked;
    }
}
