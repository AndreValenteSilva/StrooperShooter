package org.academiadecodigo.stormrooters.stroopershooter;


import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

public class Weapon {

    private int bulletNumber;   //might be a final property?

    public Weapon() {
        this.bulletNumber = 5;
    }

    public void shoot(GameObjects objects) {

        if (bulletNumber > 0) {
            bulletNumber--;
            System.out.println("bullets: " + bulletNumber);
            objects.hit();
        }
    }

    public void reload() {

        bulletNumber = 5;
    }

    public int getBulletNumber() {

        return bulletNumber;
    }
}
