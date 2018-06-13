package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stormrooters.stroopershooter.Field.GridPosition;

public abstract class Target extends GameObjects {

    private Rectangle target;

    public Target(GridPosition gridPosition) {

        super(gridPosition);
    }


    public void hit() {
        setHitted();
        hide();
    }
}
