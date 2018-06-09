package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;

public abstract class GameObjects implements Destroyable {


    private int size; //not really sure if size it's going to be an int
    private GridPosition position;
    private boolean hitted;

    public GameObjects() {

        this.hitted = false;
    }

    public GameObjects(GridPosition gridPosition) {
        //this.size = size;
        this.position = gridPosition;
    }

    public boolean isHitted() {

        return hitted;

    }

    public void setHitted() {
        this.hitted = true;

    }

    public GridPosition getPos() {
        return this.position;
    }
}
