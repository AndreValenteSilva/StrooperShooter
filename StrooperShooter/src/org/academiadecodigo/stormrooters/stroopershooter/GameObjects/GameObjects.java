package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

import org.academiadecodigo.stormrooters.stroopershooter.Field.GridDirection;
import org.academiadecodigo.stormrooters.stroopershooter.Field.GridPosition;
import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;

public abstract class GameObjects {

    private GridPosition position;
    private boolean hitted;
    private Grid grid;
    private int directionChangeLevel = 5;

    protected GridDirection currentDirection;

    public GameObjects(GridPosition gridPosition) {
        this.position = gridPosition;
        this.hitted = false;

        currentDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
    }

    public abstract int getPoints();

    public abstract void hit();

    public boolean isHitted() {
        return hitted;
    }

    public void setHitted() {
        this.hitted = true;
    }

    public int getX() {
        return this.position.getCol() * Grid.CELLSIZE + Grid.PADDING;
    }

    public int getY() {
        return this.position.getRow() * Grid.CELLSIZE + Grid.PADDING;
    }

    public GridPosition getPos() {
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

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void move() {
        translate(chooseDirection(), 2);
    }

    public GridDirection chooseDirection() {

        GridDirection newDirection = currentDirection;

        if (Math.random() > ((double) directionChangeLevel) / 10) {
            newDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

            if (newDirection.isOpposite(currentDirection)) {
                return chooseDirection();
            }
        }
        return newDirection;
    }


    public void translate(GridDirection direction, int distance) {
        GridDirection newDirection = direction;

        if (isHittingWall()) {
            newDirection = direction.oppositeDirection();
        }

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
}
