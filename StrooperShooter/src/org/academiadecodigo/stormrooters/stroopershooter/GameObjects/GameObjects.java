package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.GridDirection;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;

public abstract class GameObjects implements Destroyable {

    private SimplegfxGridPosition position;
    private boolean hitted;
    private SimplegfxGrid grid;

    protected GridDirection currentDirection;

    public GameObjects(SimplegfxGridPosition gridPosition) {
        this.position = gridPosition;
        this.hitted = false;

        currentDirection = GridDirection.values() [(int) (Math.random() * GridDirection.values().length)];
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

    public SimplegfxGridPosition getPos() {
        return position;
    }

    public void hide() {
        position.hide();
    }

    public int getWidth() {
        return position.getWidth();
    }

    public int getHeigth() {
        return position.getHeight();
    }

    public void setGrid(SimplegfxGrid grid) {
        this.grid = grid;
    }

    public void move() {
        translate(currentDirection, 1);
    }

    public void translate (GridDirection direction, int distance) {
        GridDirection newDirection = direction;

        if (isOnLimit()) {
            System.out.println("-----------------------------------------------ISONLIMIT");
            newDirection = direction.oppositeDirection();
        }

        getPos().moveInDirection(newDirection, distance);
    }

    public boolean isOnLimit() {

        switch (currentDirection) {
            case LEFT:
                if (getPos().getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (getPos().getCol() == grid.getCols() - 1) {
                    return true;
                }
                break;
        }
        return false;

    }

    public String toString() {
        return getX() + " " + getY();
    }


}
