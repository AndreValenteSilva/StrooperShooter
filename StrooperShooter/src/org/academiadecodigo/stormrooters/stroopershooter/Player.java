package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

public class Player {

    private String name;
    private int score;
    private Weapon sniper;
    private GameObjects objects;

    public Player(String name) {

        this.name = name;
        this.sniper = new Weapon(sniper.getBulletNumber());
    }

    public void moveSight() {

    }

    public void shootWeapon() {

        if (sniper.getBulletNumber() == 0) {

            sniper.reload();
        }

        sniper.shoot(objects);

    }


    //SETTER
    public void setScore(int score) {

        this.score = score;
    }
}
