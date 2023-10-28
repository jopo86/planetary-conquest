package com.jopo.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeUtils {

    public static final byte NANOS = 0;
    public static final byte MILLIS = 1;
    public static final byte SECONDS = 2;

    public static long nanos() {
        return System.nanoTime();
    }
    public static long millis() {
        return System.currentTimeMillis();
    }
    public static long seconds() {
        return millis() / 1000;
    }

    public static String getDate() {
        return LocalDate.now().toString();
    }

    public static String getTime() {
        return LocalTime.now().toString();
    }

    public static String getYear() {
        return getDate().split("-")[0];
    }

    public static String getMonth() {
        return getDate().split("-")[1];
    }

    public static String getDay() {
        return getDate().split("-")[2];
    }

    public static class Stopwatch {
        private Stopwatch() {}

        private static long start = 0;
        private static long end = 0;
        private static boolean running = false;

        private static byte mode = 1;

        public static void setMode(byte _mode) {
            if (running) throw new RuntimeException("setMode() cannot be called while stopwatch is running");
            mode = _mode;
        }

        public static void start() {
            running = true;
            switch (mode) {
                case NANOS -> start = nanos();
                case MILLIS -> start = millis();
                case SECONDS ->  start = seconds();
            }
        }

        public static long end() {
            if (!running) throw new RuntimeException("end() called before start()");
            running = false;
            switch (mode) {
                case NANOS -> end = nanos() - start;
                case MILLIS -> end = millis() - start;
                case SECONDS ->  end = seconds() - start;
            }
            return end;
        }

        public static long getTime() {
            if (running) switch (mode) {
                case NANOS -> {
                    return nanos() - start;
                }
                case MILLIS -> {
                    return millis() - start;
                }
                case SECONDS -> {
                    return seconds() - start;
                }
            }
            return end;
        }
    }

}
