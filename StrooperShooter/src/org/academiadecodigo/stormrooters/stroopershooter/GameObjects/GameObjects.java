package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.GridDirection;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Position.SimplegfxGridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;

public abstract class GameObjects implements Destroyable {

    private SimplegfxGridPosition position;
    private boolean hitted;
    private SimplegfxGrid grid;
    private int directionChangeLevel = 5;

    protected GridDirection currentDirection;

    public GameObjects(SimplegfxGridPosition gridPosition) {
        this.position = gridPosition;
        this.hitted = false;

        currentDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
    }

    public abstract int getPoints();

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
        translate(chooseDirection(), 1);
    }

    public GridDirection chooseDirection() {

        // Let's move in the same direction by default
        GridDirection newDirection = currentDirection;

        // Sometimes, we want to change direction...
        if (Math.random() > ((double) directionChangeLevel) / 10) {
            newDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

            // but we do not want to perform U turns..
            if (newDirection.isOpposite(currentDirection)) {
                return chooseDirection();
            }
        }
        return newDirection;
    }

    public void translate(GridDirection direction, int distance) {
        GridDirection newDirection = direction;

        // Perform a U turn if we have bumped against the wall
        if (isHittingWall()) {
            newDirection = direction.oppositeDirection();
        }

        // Accelerate in the choosen direction
        this.currentDirection = newDirection;

        getPos().moveInDirection(newDirection, distance);
    }


    public boolean isHittingWall() {

        switch (currentDirection) {
            case LEFT:
                if (getPos().getCol() == 10) {
                    return true;
                }
                break;
            case RIGHT:
                if (getPos().getCol() >= grid.getCols() - 10) {
                    return true;
                }
                break;
            case UP:
                if (getPos().getRow() == 3) {
                    return true;
                }
                break;
            case DOWN:
                if (getPos().getRow() >= grid.getRows() - 30) {
                    return true;
                }
        }
        return false;

    }

    public String toString() {
        return getX() + " " + getY();
    }


}
