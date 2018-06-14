package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.GridPosition;

public class Friend extends GameObjects{

    private int points;
    private int fuckedUpCounter = 0;

    public Friend(GridPosition gridPosition) {
        super(gridPosition);
        this.points = -200;
    }

    public void hit() {
        setHitted();
        hide();
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
