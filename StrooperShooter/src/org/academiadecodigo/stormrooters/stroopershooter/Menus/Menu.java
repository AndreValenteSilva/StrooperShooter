package org.academiadecodigo.stormrooters.stroopershooter.Menus;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {


    private int mouseX;
    private int mouseY;
    private Picture menuBackground;
    private Picture instructions;
    private Picture gameOver;



    public Menu() {
        new MenuMouse();
        this.instructions = new Picture(0,0);
        this.menuBackground = new Picture(0,0);
        this.gameOver = new Picture(0,0);


    }

    public void menuOption(){

        //if (getMouseX() >=  && getMouseX() <=  && getMouseY() >=  && getMouseY() <= ) {

        //}
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
