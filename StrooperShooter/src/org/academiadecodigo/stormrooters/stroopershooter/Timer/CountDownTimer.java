package org.academiadecodigo.stormrooters.stroopershooter.Timer;

public class CountDownTimer {

    public static void main(String[] args) throws Exception {


        int i = 10;

        while (i != 0) {
            System.out.println("\b" + i);

            i--;

            Thread.sleep(1000);
        }


        System.out.println("\b*****************");
        System.out.println("Game Over");
        System.out.println("******************");


    }

}
