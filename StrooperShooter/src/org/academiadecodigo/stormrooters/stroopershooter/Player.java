package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

public class Player {

    private String name;
    private int score;
    private Weapon sniper;
    private GameObjects objects;
    private int X;
    private int Y;
    private WeaponControl weaponControl;
    private ReloadControl reloadControl;

    public Player(String name, Weapon weapon) {

        this.name = name;
        this.sniper = new Weapon();
        this.weaponControl = new WeaponControl();
        this.reloadControl = new ReloadControl();
    }

    public void moveSight() {
        // mouseHandler logic
    }

    public void shootWeapon(GameObjects objects) {
        this.objects = objects;

        if (sniper.getBulletNumber() > 0) {
            sniper.shoot(objects);
        }
        // else say reload
    }

    public void reload() {

        sniper.reload();

    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    //SETTER
    public void setScore(int points) {

        this.score += points;
        System.out.println("score: " + score);
    }

    //NESTED NESTED NESTED
    public class WeaponControl implements MouseHandler {

        private Mouse handler;

        public WeaponControl() {

            this.handler = new Mouse(this);
            addEventListener();

        }

        public void addEventListener() {

            handler.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            X = (int) e.getX();
            Y = (int) e.getY();
            System.out.println("X:" + X + "Y:" + Y);
            shootWeapon(objects);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    public class ReloadControl implements KeyboardHandler {

        private Keyboard key;
        private KeyboardEvent spaceKey;


        public ReloadControl() {

            this.key = new Keyboard(this);
            this.spaceKey = new KeyboardEvent();

            setEvent();
            addEventListener();
        }


        public void setEvent() {

            spaceKey.setKey(KeyboardEvent.KEY_SPACE);
            spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        }

        public void addEventListener(){

            key.addEventListener(spaceKey);
        }

        @Override
        public void keyPressed(KeyboardEvent e) {
            System.out.println("reaload");
            reload();
        }


        @Override
        public void keyReleased(KeyboardEvent e) {

        }
    }
}
