package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.Target;

import java.util.Iterator;

public class Game {

    private int timer; //the type must be changed
    private Player player;
    private Grid grid;
    private GameObjects gameObjects;
    private Target objects;
    private boolean gameInit;

    public static final int BULLET_DAMAGE = 1;


    public Game(int col, int row) {

        grid = new SimplegfxGrid(col, row);

        //this.gameObjects = createObjects(numberObjects);

    }

    public void init() {

        grid.init();

        for (int i = 0; i < 5; i++) {
            objects = new Target(grid.makeGridPosition());
            System.out.println(objects.getPos().toString());
        }

        while (gameInit) {
            try {
                Thread.sleep(100);
                System.out.println("hfg");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            start();
            System.out.println("before start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() throws InterruptedException {

        //objects = new Target(grid.makeGridPosition(20, 20));
        System.out.println("out while");

        while (true) {
            Thread.sleep(100);
            System.out.println("while");
        }
    }

    public GameObjects createObjects(int numberObjects) {
        return null;
    }


    public int givePoints() {
        return gameObjects.getPoints();
    }


    public void moveTarget() {
    }


    public String gameOver() {
        return "Game Over";
    }




/*    //NESTED CLASS NESTED CLASS NESTED CLASS  ---> Not sure about this class, perhaps, shall be in a different window??

    public class LinkedList<T> implements Iterable<T> {

        private Node head;
        private int length = 0;
        private int max;
        private int min;

        public LinkedList() {

            this.head = new Node(null);
        }


        @Override
        public Iterator<T> iterator() {

            return new MyIterator() {
            };
        }


        //NESTED CLASS NODE

        private class Node {

            private T data;
            private Node next;

            public Node(T data) {
                this.data = data;
                next = null;
            }

            public T getT() {

                return data;
            }

            public void setData(T data) {

                this.data = data;
            }

            public Node getNext() {

                return next;
            }

            public void setNext(Node next) {

                this.next = next;
            }
        }


        private class MyIterator implements Iterator<T> {

            private Node currentNode;
            private Node nextNode;


            public MyIterator() {

                this.currentNode = head;
                this.nextNode = currentNode.getNext();
            }


            @Override
            public T next() {

                currentNode = currentNode.getNext();
                nextNode = currentNode.getNext();

                return currentNode.getT();
            }

            @Override
            public boolean hasNext() {

                if (currentNode != null) {
                    return true;
                }

                return false;
            }

        }

    }*/
}

