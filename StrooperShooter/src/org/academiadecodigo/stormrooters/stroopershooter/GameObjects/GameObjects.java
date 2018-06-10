package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.GridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;

public abstract class GameObjects implements Destroyable {

    private SimplegfxGridPosition position;
    private boolean hitted;

    public GameObjects(SimplegfxGridPosition gridPosition) {
        this.position = gridPosition;
        this.hitted = false;
    }

    public boolean isHitted() {
        return hitted;
    }

    public void setHitted() {
        this.hitted = true;
    }

    public int getX() {
        return this.position.getCol() * SimplegfxGrid.CELLSIZE + SimplegfxGrid.PADDING;
    }

    public int getY() {
        return this.position.getRow() * SimplegfxGrid.CELLSIZE + SimplegfxGrid.PADDING;
    }

    public GridPosition getPos() {
        return position;
    }

    public int getWidth() {
        return position.getWidth();
    }

    public int getHeigth() {
        return position.getHeight();
    }

    public String toString() {
        return getX() + " " + getY();
    }


}
