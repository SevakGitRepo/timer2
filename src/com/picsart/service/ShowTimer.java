package com.picsart.service;

import com.picsart.model.Timer;

public class ShowTimer {

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

    public static void showTime(Timer timer) {
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
