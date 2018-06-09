package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

public class Player {

    private String name;
    private int score;
    private Weapon sniper;
    private GameObjects objects;

    public Player(String name, Weapon weapon) {

        this.name = name;
        this.sniper = weapon;
    }

    public void moveSight() {
        // mouseHandler logic
    }

    public void shootWeapon() {

        if (sniper.getBulletNumber() > 0) {
            sniper.shoot(objects);
        }
        // else say reload
    }

    public void reload() {

        //receives input from keyboard
        sniper.reload();
    }


    //SETTER
    public void setScore(int score) {

        this.score = score;
    }
}
