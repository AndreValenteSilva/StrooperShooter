package org.academiadecodigo.stormrooters.stroopershooter;

import org.academiadecodigo.stormrooters.stroopershooter.Field.Grid;
import org.academiadecodigo.stormrooters.stroopershooter.Field.SimplegfxGrid;
import org.academiadecodigo.stormrooters.stroopershooter.GameObjects.GameObjects;

import java.util.Iterator;

public class Game {

    private int timer; //the type must be changed
    private Player player;

    private Grid grid;
    private GameObjects gameObjects;
    private Weapon sniper;

    public static final int BULLET_DAMAGE = 1;


    public Game(int numberObjects) {
        this.player = new Player("Batata", sniper);
        this.sniper = new Weapon();
        this.gameObjects = createObjects(numberObjects);

    }

    public void init() {
        grid = new SimplegfxGrid(124, 86);
    }

    public void start() {

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


    //NESTED CLASS NESTED CLASS NESTED CLASS  ---> Not sure about this class, perhaps, shall be in a different window??

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

    }
}

