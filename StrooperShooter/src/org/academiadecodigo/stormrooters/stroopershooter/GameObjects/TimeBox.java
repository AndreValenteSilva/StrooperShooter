package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;

public class TimeBox extends Box {

    private int bonus;

    public TimeBox(SimplegfxGridPosition gridPosition) {
        super(gridPosition);
        this.bonus = 5;
    }

    @Override
    public int getBonus() {

        //adds bonus(5?)seconds to game timer
        //time.delayTime;

        return this.bonus;
    }
}
