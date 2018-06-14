package org.academiadecodigo.stormrooters.stroopershooter.Menus;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.stormrooters.stroopershooter.Game;

public class Menu {


    private int mouseX;
    private int mouseY;
    private Picture menuBackground;
    private Picture instructions;
    private Picture gameOver;



    public Menu() {
        new MenuMouse();
        this.instructions = new Picture(0, 0, "gameover.png");
        this.menuBackground = new Picture(0, 0, "menuInitial.jpg");
        this.gameOver = new Picture(0, 0, "gameover.png");


    }

    public void menuOption(Game game) throws InterruptedException {

        mainMenu();
        Thread.sleep(20);
        if (getMouseX() >= 100 && getMouseX() <= 100 && getMouseY() >= 100 && getMouseY() <= 100) {

            game.init();

        }
    }

    private int getMouseX() {
        return mouseX;
    }

    private int getMouseY() {
        return mouseY;
    }


    public void mainMenu() {
        menuBackground.draw();
    }

    public void exitMainMenu() {
        menuBackground.delete();
    }


    public void instructions() {
        instructions.draw();
    }

    public void gameOver() {
        gameOver.draw();
    }


    private class MenuMouse implements MouseHandler {
        private Mouse mouse;

        MenuMouse() {
            this.mouse = new Mouse(this);
            addEventListener();
        }

        void addEventListener() {
            mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            mouseX = (int) e.getX();
            mouseY = (int) e.getY();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }


}
