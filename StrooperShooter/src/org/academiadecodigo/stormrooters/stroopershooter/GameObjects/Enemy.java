package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

public class Enemy extends Target{

    private int points;

    public Enemy() {
        this.points = 5;
    }

    @Override
    public int getPoints() {
        return this.points;
    }
}
