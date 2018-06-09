package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

public class TimeBox extends Box {

    private int bonus;

    public TimeBox() {
        this.bonus = 5;
    }

    @Override
    public int getBonus() {
        //adds bonus(5?)seconds to game timer
        //time.delayTime;
        return this.bonus;
    }

}
