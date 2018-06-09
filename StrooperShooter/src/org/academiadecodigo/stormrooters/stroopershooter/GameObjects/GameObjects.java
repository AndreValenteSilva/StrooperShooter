package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position;

public abstract class GameObjects {

    private int size; //not really sure if size it's going to be an int
    private Position position;
    private boolean hitted;
    private int points;

    public GameObjects(int size, Position position) {

        this.size = size;
        this.position = position;
    }

    public boolean isHitted() {

        return hitted = true;
    }

    //GETTER

    public int getPoints() {

        return points;
    }
}
