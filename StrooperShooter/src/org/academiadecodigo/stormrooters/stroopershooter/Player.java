package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private int score;
    private Weapon sniper;
    private int X;
    private int Y;
    Picture aim;
    private WeaponControl weaponControl;
    private ReloadControl reloadControl;
    private Sound[] sound;

    public Player(Weapon weapon) {
        this.sniper = weapon;
        this.weaponControl = new WeaponControl();
        this.reloadControl = new ReloadControl();
        this.sound = new Sound[2];
        sound[0] = new Sound("/blaster.wav");
        sound[1] = new Sound("/nobullets.wav");
        this.aim = new Picture(2, 2, "finalCrosshair.png");
    }

    public void shootWeapon() {
        if (sniper.getBulletNumber() > 0) {
            sniper.shoot();
            sound[0].play(true);
        } else {
            sound[1].play(true);
        }
    }

    public void reload() {
        sniper.reload();
    }

    public void drawAim() {
        aim.draw();
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void reset() {
        this.X = 0;
        this.Y = 0;
    }

    public int getBulletNumber() {
        return sniper.getBulletNumber();
    }

    public void setScore(int points) {
        this.score += points;
        System.out.println("score: " + score);
    }

    public int getScore() {
        return score;
    }

    public void deleteAim() {
        aim.delete();
    }

    public class WeaponControl implements MouseHandler {

        private Mouse handler;

        public WeaponControl() {
            this.handler = new Mouse(this);
            addEventListener();

        }

        public void addEventListener() {
            handler.addEventListener(MouseEventType.MOUSE_CLICKED);
            handler.addEventListener(MouseEventType.MOUSE_MOVED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            X = (int) e.getX();
            Y = (int) e.getY() - 25;
            shootWeapon();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int x = aim.getX() + 20;
            int y = aim.getY() + 46;

            if (x > 0 && x < 1239 && y > 0 && y < 770) {
                aim.translate(e.getX() - x, e.getY() - y);
            } else {
                x = -10;
                y = -10;
                aim.translate(x, y);
            }
        }
    }

    public class ReloadControl implements KeyboardHandler {

        public ReloadControl() {

            Keyboard keyboard = new Keyboard(this);

            KeyboardEvent space = new KeyboardEvent();
            space.setKey(KeyboardEvent.KEY_SPACE);
            space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(space);
        }

        @Override
        public void keyPressed(KeyboardEvent e) {
            switch (e.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    reload();
                    System.out.println("thaReaLoad");
            }
        }

        @Override
        public void keyReleased(KeyboardEvent e) {
        }
    }
}
