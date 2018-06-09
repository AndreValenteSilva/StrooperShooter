package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;

public class Target extends GameObjects {

    private Rectangle target;

    public Target(GridPosition gridPosition) {

        super(gridPosition);
        target = new Rectangle(50, 50, 40, 20);
        target.fill();
    }

    @Override
    public boolean isHitted() {

        return super.isHitted();
    }
}
