package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.Position;

public abstract class GameObjects implements Destroyable{


    private boolean hitted;

    public GameObjects() {

        this.hitted = false;
    }

    public void isHitted() {
        this.hitted = true;
    }
}
