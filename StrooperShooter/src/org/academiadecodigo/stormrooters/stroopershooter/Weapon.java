package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

public class Weapon {

    private int bulletNumber;   //might be a final property?


    public Weapon(int bulletNumber) {

        this.bulletNumber = bulletNumber;
    }


    public void shoot(GameObjects objects) {

        bulletNumber--;
    }


    public void reload() {

        bulletNumber += 5;
    }


    public int getBulletNumber() {

        return bulletNumber;
    }
}