package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.Position;

public abstract class GameObjects {

    private int size; //not really sure if size it's going to be an int
    private GridPosition position;
    private boolean hitted;
    private int points;

    public GameObjects(GridPosition gridPosition) {

        //this.size = size;
        this.position = gridPosition;
    }

    public boolean isHitted() {

        return hitted = true;
    }

    //GETTER

    public int getPoints() {

        return points;
    }
}
