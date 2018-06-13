package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;


import org.academiadecodigo.stormrooters.stroopershooter.Field.GridPosition;

public class TimeBox extends Box {

    private int bonus;

    public TimeBox(GridPosition gridPosition) {
        super(gridPosition);
        this.bonus = 5;
    }

    @Override
    public int getPoints() {
        return this.bonus;
    }

    public void hit() {
        setHitted();
        hide();
    }
}
