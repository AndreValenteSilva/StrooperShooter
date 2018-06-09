package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position;

public abstract class GameObjects {


    // gameobject doesnt need to know its position in the field, rigth?
    // only needs to know if hitted

    //private int size; //not really sure if size it's going to be an int
    //private Position position;

    private boolean hitted;

    public GameObjects() {

        this.hitted = false;
    }

    public void setHitted() {
        this.hitted = true;
    }
}
