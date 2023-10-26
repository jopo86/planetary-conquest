package com.jopo.utils;

public class TimeUtils {

    public static long getMillis() {
        return System.currentTimeMillis();
    }

    public static class Stopwatch {
        private Stopwatch() {}

        private static long start = 0;
        private static long end = 0;
        private static boolean running = false;

        public static void start() {
            running = true;
            start = getMillis();
        }

        public static long end() {
            if (!running) throw new RuntimeException("end() called before start()");
            running = false;
            end = getMillis() - start;
            return end;
        }

        public static long getTime() {
            if (running) return getMillis() - start;
            else return end;
        }

    }

}
