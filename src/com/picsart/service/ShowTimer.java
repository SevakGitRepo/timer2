package com.picsart.service;

import com.picsart.model.Timer;

public class ShowTimer implements Runnable {
    private Timer timer;

    public ShowTimer(Timer timer) {
        this.timer = timer;
    }

    private static void print(int hour, int minute, int second) {

        StringBuilder stringBuilder = new StringBuilder();
        if (hour < 10) {
            stringBuilder.append("0").append(hour).append(":");
        } else {
            stringBuilder.append(hour).append(":");
        }
        if (minute < 10) {
            stringBuilder.append("0").append(minute).append(":");
        } else {
            stringBuilder.append(minute).append(":");
        }
        if (second < 10) {
            stringBuilder.append("0").append(second);
        } else {
            stringBuilder.append(second);
        }
        System.out.println(stringBuilder.toString());
    }

    @Override
    public void run() {
        int hour = timer.getHour();
        int minute = timer.getMinute();
        int second = timer.getSecond();
        do {
            if (second == 0) {
                if (minute == 0) {
                    hour--;
                    minute = 59;
                } else {
                    minute--;
                }
                second = 59;
            } else {
                second--;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print(hour, minute, second);
        } while (hour != 0 || minute != 0 || second != 0);
    }
}
