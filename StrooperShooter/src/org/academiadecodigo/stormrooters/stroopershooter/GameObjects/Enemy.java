package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

public class Enemy extends Target {

    private int points;
    private int fuckedUpCounter = 0;

    public Enemy() {
        this.points = 5;
    }

    @Override
    public int getPoints() {
        if (fuckedUpCounter < 1) {
            fuckedUpCounter++;
            return this.points;
        }
        return 0;
    }
}
