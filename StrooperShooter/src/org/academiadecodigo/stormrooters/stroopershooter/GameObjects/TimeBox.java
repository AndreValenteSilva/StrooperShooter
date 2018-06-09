package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;

public class TimeBox extends Box {

    private int bonus;

    public TimeBox(GridPosition gridPosition) {
        super(gridPosition);
        this.bonus = 5;
    }

    @Override
    public int getBonus() {
        //adds bonus(5?)seconds to game timer
        //time.delayTime;
        return this.bonus;
    }

    @Override
    public  int getPoints() {
        return 0;
    }

}
