package org.academiadecodigo.stormrooters;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    int secondsPassed = 30;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed--;
            System.out.println(secondsPassed);
        }
    };

    public void start() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public static void main(String[] args) {
        TimerTest test = new TimerTest();
        test.start();
    }
}
