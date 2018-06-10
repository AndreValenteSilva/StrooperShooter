package org.academiadecodigo.stormrooters.stroopershooter.Timer;

import org.academiadecodigo.stormrooters.stroopershooter.Game;

import java.util.Timer;
import java.util.TimerTask;

public class CountDownTimer {

    private int seconds;


    public CountDownTimer(int seconds) {
        this.seconds = seconds;
    }

    Timer timer = new Timer();

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (seconds > 0) {
                seconds--;
                System.out.println(seconds);
            } else {

                System.out.println("Game Over");
            }
        }
    };

    TimerTask timerObject = new TimerTask() {
        @Override
        public void run() {
            if (seconds > 0) {
                seconds--;
                System.out.println(seconds);
            }

            if (seconds == 0) {
                System.out.println("Object disappear");
                seconds = 5;
            }

        }
    };

    public void startCountTimer() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void countdownObject() {
        timer.scheduleAtFixedRate(timerObject, 1000, 1000);
    }

    public int getSeconds() {
        return seconds;
    }
}
