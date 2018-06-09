package org.academiadecodigo.stormrooters.stroopershooter;

public class Timer {

    private int countingTime;


    public Timer() {

    }


    public void countTime(){

        countingTime++;
    }

    public void delayTime() {

        countingTime--;
    }
}
