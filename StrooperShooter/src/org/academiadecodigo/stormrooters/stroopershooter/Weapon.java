package org.academiadecodigo.stormrooters.stroopershooter;

public class Weapon {

    private int bulletNumber;   //might be a final property?

    public Weapon() {
        this.bulletNumber = 5;
    }

    public void shoot() {
        bulletNumber--;
    }

    public void reload() {
        bulletNumber = 5;
    }

    public int getBulletNumber() {
        return bulletNumber;
    }
}
