package org.academiadecodigo.stormrooters.stroopershooter;

import com.sun.tools.internal.xjc.util.MimeTypeRange;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

public class Weapon {

    private int bulletNumber;   //might be a final property?
    private Sight sight;

    public Weapon() {
        sight = new Sight();
        this.bulletNumber = 5;
    }


    public void shoot(GameObjects objects) {

        bulletNumber--;
    }


    public void reload() {

        bulletNumber = 5;
    }


    public int getBulletNumber() {

        return bulletNumber;
    }
}
