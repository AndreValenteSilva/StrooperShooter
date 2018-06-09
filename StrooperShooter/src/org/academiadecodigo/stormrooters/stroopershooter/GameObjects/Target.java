package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

public abstract class Target extends GameObjects {


    public Target() {

        super();
    }

    public abstract int getPoints();

    public void hit() {

        getPoints();

        setHitted();
    }
}
