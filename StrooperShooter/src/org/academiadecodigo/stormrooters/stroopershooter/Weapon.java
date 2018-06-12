package org.academiadecodigo.stormrooters.stroopershooter;


import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

import java.sql.SQLOutput;

public class Weapon {

    private int bulletNumber;   //might be a final property?

    public Weapon() {
        this.bulletNumber = 5;
    }

    public void shoot() {

        if (bulletNumber > 0) {
            bulletNumber--;
            Picture shot = new Picture(62, 0, "laser.png");

            shot.draw();
            shot.delete();
            System.out.println("bullets: " + bulletNumber);
        } else {
            reload();
            bulletNumber--;
            System.out.println("Reload");
            System.out.println("bullets: " + bulletNumber);
        }
    }

    public void reload() {

        bulletNumber = 5;
    }

    public int getBulletNumber() {

        return bulletNumber;
    }
}
