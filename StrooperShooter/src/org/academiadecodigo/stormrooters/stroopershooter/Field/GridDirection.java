package org.academiadecodigo.stormrooters.stroopershooter.Field;

public enum GridDirection {

    LEFT,
    RIGHT;

    public GridDirection oppositeDirection() {

        GridDirection opposite = null;

        switch (this) {
            case LEFT:
                opposite = GridDirection.RIGHT;
                System.out.println("Left - GridDirection");
                break;
            case RIGHT:
                opposite = GridDirection.LEFT;
                System.out.println("Rigth - GridDirection");
        }
        return opposite;
    }
}
