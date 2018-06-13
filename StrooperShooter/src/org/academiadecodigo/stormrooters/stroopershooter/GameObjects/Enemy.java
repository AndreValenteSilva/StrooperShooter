package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.GridPosition;

public class Enemy extends GameObjects {
    private int points;
    private int fuckedUpCounter = 0;

    public Enemy(GridPosition gridPosition) {
        super(gridPosition);
        this.points = 5;
    }

    public void hit() {
        setHitted();
        hide();
    }

    @Override
    public int getPoints() {
        if (fuckedUpCounter < 1) {
            fuckedUpCounter++;
            System.out.println("You hit a enemy!");
            return this.points;
        }
        return 0;
    }
}
