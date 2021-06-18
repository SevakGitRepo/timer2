package com.picsart;

import com.picsart.model.Timer;
import com.picsart.service.ShowTimer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please set time HH:MM:SS");
        String time = scanner.nextLine();
        if (!time.matches("^([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")) {
            System.out.println("Time is incorrect");
        } else {
            timer.setHour(Integer.parseInt(time.substring(0, 2)));
            timer.setMinute(Integer.parseInt(time.substring(3, 5)));
            timer.setSecond(Integer.parseInt(time.substring(6)));
        }

        Thread thread = new Thread(() -> ShowTimer.showTime(timer));
        thread.start();
        thread.join();
    }
}
