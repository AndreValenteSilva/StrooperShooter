package org.academiadecodigo.stormrooters.stroopershooter.GameObjects;

public class GameObjectFactory {

    public static final int BOX_ARMOUR = 2;

    public static GameObjects createObject() {

        return Math.random() > 0.3 ? new Target(10, position): new Box(10, position, BOX_ARMOUR);
        return null;
    }
}
