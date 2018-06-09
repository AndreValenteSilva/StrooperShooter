package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;

public class Enemy extends Target{

    private int points;

    public Enemy(GridPosition gridPosition) {
        super(gridPosition);
        this.points = 5;
    }

    @Override
    public int getPoints() {
        return this.points;
    }
}
