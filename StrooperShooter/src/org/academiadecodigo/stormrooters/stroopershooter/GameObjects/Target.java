package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

public abstract class Target extends GameObjects {

    private int points;

    public Target() {

        super();
    }


    public void hit() {

        setHitted();
    }
}
