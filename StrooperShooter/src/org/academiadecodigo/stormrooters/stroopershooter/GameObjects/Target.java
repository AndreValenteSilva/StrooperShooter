package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;

public abstract class Target extends GameObjects {

    private Rectangle target;

    public Target(SimplegfxGridPosition gridPosition) {

        super(gridPosition);
    }


    public void hit() {
        setHitted();
        hide();
    }
}
