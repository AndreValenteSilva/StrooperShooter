package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;

public class Enemy extends Target{
    private int points;
    private int fuckedUpCounter = 0;

    public Enemy(SimplegfxGridPosition gridPosition) {
        super(gridPosition);
        this.points = 5;
    }

    @Override
    public int getPoints() {
        if (fuckedUpCounter < 1) {
            fuckedUpCounter++;
            System.out.println("You bastard!");
            return this.points;
        }
        return 0;
    }
}
