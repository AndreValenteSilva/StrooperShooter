package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

public class Weapon {

    private int bullets;

    public Weapon() {

    }

    public void shoot(GameObjects objects) {
        bullets--;
    }

    public void reload() {
        bullets += 5;
    }
}
