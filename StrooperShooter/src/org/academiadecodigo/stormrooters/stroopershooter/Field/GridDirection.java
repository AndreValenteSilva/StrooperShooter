package org.academiadecodigo.stormrooters.stroopershooter.Field;

public enum GridDirection {
    DOWN,
    UP,
    LEFT,
    RIGHT;

    public boolean isOpposite(GridDirection dir) {
        return dir.equals(oppositeDirection());
    }

    public GridDirection oppositeDirection() {

        GridDirection opposite = null;

        switch (this) {
            case UP:
                opposite = GridDirection.DOWN;
                break;
            case DOWN:
                opposite = GridDirection.UP;
                break;
            case LEFT:
                opposite = GridDirection.RIGHT;
                break;
            case RIGHT:
                opposite = GridDirection.LEFT;
                break;
        }
        return opposite;
    }
}
