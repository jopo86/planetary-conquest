package com.jopo.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class TimeUtils {

    private static String[] tmpStrArr;

    public static final byte NANOS = 0;
    public static final byte MILLIS = 1;
    public static final byte SECONDS = 2;

    public static final byte AM = 3;
    public static final byte PM = 4;

    public static final String[] monthStrings = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
    public static final HashMap<String, String> monthAbbreviations = new HashMap<>() {
        {
            put("January", "Jan");
            put("February", "Feb");
            put("March", "Mar");
            put("April", "Apr");
            put("May", "May");
            put("June", "Jun");
            put("July", "Jul");
            put("August", "Aug");
            put("September", "Sep");
            put("October", "Oct");
            put("November", "Nov");
            put("December", "Dec");
        }
    };

    public static class Date {
        int month;
        int day;
        int year;

        public Date(int month, int day, int year) {
            this.month = month;
            this.day = day;
            this.year = year;
        }

        public Date(String month, String day, String year) {
            this.month = Integer.parseInt(month);
            this.day = Integer.parseInt(day);
            this.year = Integer.parseInt(year);
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public int getYear() {
            return year;
        }

        public String format() {
            return month + "/" + day + "/" + year;
        }

        public String formalFormat() {
            return getMonthName(month) + " " + day + ", " + year;
        }

        public String abbreviatedFormalFormat() {
            return getAbbreviatedMonthName(month) + " " + day + ", " + year;
        }
    }

    public static class Time {
        int hr;
        int min;
        int sec;
        byte meridiem;

        public Time(int hr, int min, int sec) {
            if (hr == 0) {
                meridiem = AM;
                this.hr = 12;
            }
            else if (hr > 0 && hr < 12) {
                meridiem = AM;
                this.hr = hr;
            } else if (hr == 12) {
                meridiem = PM;
                this.hr = 12;
            } else {
                meridiem = PM;
                this.hr = hr - 12;
            }
            this.min = min;
            this.sec = sec;
        }

        public Time(String hr, String min, String sec) {
            this(Integer.parseInt(hr), Integer.parseInt(min), (int)Double.parseDouble(sec));
        }

        public int getHours() {
            return hr;
        }

        public int getMinutes() {
            return min;
        }

        public int getSeconds() {
            return sec;
        }

        public byte getMeridiem() {
            return meridiem;
        }

        public MilitaryTime toMilitaryTime() {
            return new MilitaryTime((meridiem == AM ? (hr == 12 ? 0 : hr) : hr + 12), min, sec);
        }

        public String format() {
            return (hr < 10 ? "0" + hr : hr) + ":" + (min < 10 ? "0" + min : min) + ":" + (sec < 10 ? "0" + sec : sec) + " " + (meridiem == AM ? "am" : "pm");
        }
    }

    public static class MilitaryTime {
        int hr;
        int min;
        int sec;

        public MilitaryTime(int hr, int min, int sec) {
            this.hr = hr;
            this.min = min;
            this.sec = sec;
        }

        public MilitaryTime(String hr, String min, String sec) {
            this(Integer.parseInt(hr), Integer.parseInt(min), (int)Double.parseDouble(sec));
        }

        public int getHours() {
            return hr;
        }

        public int getMinutes() {
            return min;
        }

        public int getSeconds() {
            return sec;
        }

        public Time to12HrTime() {
            return new Time(hr, min, sec);
        }

        public String format() {
            return hr + ":" + min + ":" + sec;
        }
    }

    public static long nanos() {
        return System.nanoTime();
    }
    public static long millis() {
        return System.currentTimeMillis();
    }
    public static long seconds() {
        return millis() / 1000;
    }

    public static Date getDate() {
        tmpStrArr = LocalDate.now().toString().split("-");
        return new Date(tmpStrArr[1], tmpStrArr[2], tmpStrArr[0]);
    }

    public static Time getTime() {
        tmpStrArr = LocalTime.now().toString().split(":");
        return new Time(tmpStrArr[0], tmpStrArr[1], tmpStrArr[2]);
    }

    public static MilitaryTime getMilitaryTime() {
        tmpStrArr = LocalTime.now().toString().split(":");
        return new MilitaryTime(tmpStrArr[0], tmpStrArr[1], tmpStrArr[2]);
    }

    public static String getMonthName(int month) {
        return monthStrings[month - 1];
    }

    public static String getAbbreviatedMonthName(int month) {
        return monthAbbreviations.get(monthStrings[month - 1]);
    }

    public static String getAbbreviatedMonthName(String month) {
        return monthAbbreviations.get(month);
    }

    public static String formatMillis(long millis) {
        if (millis < 1000) {
            return millis + "ms";
        }
        if (millis < 60000) {
            return (millis / 1000) + "s " + (millis % 1000) + "ms";
        }
        if (millis < 3600000) {
            return (millis / 60000) + "min " + (millis % 60000 / 1000) + "s " + (millis % 60000 % 1000) + "ms";
        } else {
            return (millis / 3600000) + "hr " + (millis % 3600000 / 60000) + "min " + (millis % 3600000 % 60000 / 1000) + "s " + (millis % 3600000 % 60000 % 1000) + "ms";
        }
    }

    public static class Stopwatch {

        private long start;
        private long end;
        private boolean running;
        private byte mode;

        public Stopwatch() {
            start = 0;
            end = 0;
            running = false;
            mode = MILLIS;
        }

        public Stopwatch(byte mode) {
            start = 0;
            end = 0;
            running = false;
            this.mode = mode;
        }

        public void start() {
            running = true;
            switch (mode) {
                case NANOS -> start = nanos();
                case MILLIS -> start = millis();
                case SECONDS ->  start = seconds();
            }
        }

        public long end() {
            if (!running) throw new RuntimeException("end() called before start()");
            running = false;
            switch (mode) {
                case NANOS -> end = nanos() - start;
                case MILLIS -> end = millis() - start;
                case SECONDS ->  end = seconds() - start;
            }
            return end;
        }

        public long getTime() {
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

        public void setMode(byte mode) {
            if (running) throw new RuntimeException("setMode() cannot be called while stopwatch is running");
            this.mode = mode;
        }
    }

    public static class Countdown {

        private long start;
        private long end;
        private long amount;
        private boolean running;
        private byte mode;

        public Countdown() {
            start = 0;
            amount = 0;
            end = 0;
            running = false;
            mode = SECONDS;
        }

        public Countdown(byte mode) {
            start = 0;
            amount = 0;
            end = 0;
            running = false;
            this.mode = mode;
        }

        public void start(long amount) {
            running = true;
            this.amount = amount;
            switch (mode) {
                case NANOS -> start = nanos();
                case MILLIS -> start = millis();
                case SECONDS ->  start = seconds();
            }
            new Thread(() -> {
                try {
                    switch (mode) {
                        case NANOS -> {
                            Thread.sleep(amount / 1000000);
                        }
                        case MILLIS -> {
                            Thread.sleep(amount);
                        }
                        case SECONDS -> {
                            Thread.sleep(amount * 1000);
                        }
                    }
                } catch(InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
                running = false;
            }).start();
        }

        public long getTime() {
            return amount - (end - start);
        }

        public void setMode(byte mode) {
            if (running) throw new RuntimeException("setMode() cannot be called while countdown is running");
            this.mode = mode;
        }
    }

    public static class CountdownEvent {

        private long start;
        private long amount;
        private boolean running;
        private byte mode;

        public CountdownEvent() {
            start = 0;
            amount = 0;
            running = false;
            mode = SECONDS;
        }

        public CountdownEvent(byte mode) {
            start = 0;
            amount = 0;
            running = false;
            this.mode = mode;
        }

        public void start(long amount, Runnable event) {
            running = true;
            this.amount = amount;
            switch (mode) {
                case NANOS -> start = nanos();
                case MILLIS -> start = millis();
                case SECONDS ->  start = seconds();
            }
            new Thread(() -> {
                try {
                    switch (mode) {
                        case NANOS -> {
                            Thread.sleep(amount / 1000000);
                        }
                        case MILLIS -> {
                            Thread.sleep(amount);
                        }
                        case SECONDS -> {
                            Thread.sleep(amount * 1000);
                        }
                    }
                } catch(InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
                running = false;
                event.run();
            }).start();
        }

        public long getTime() {
            if (mode == NANOS) {
                return (long)MathUtils.clampFloor(amount - (nanos() - start), 0);
            }
            if (mode == MILLIS) {
                return (long)MathUtils.clampFloor(amount - (millis() - start), 0);
            }
            if (mode == SECONDS) {
                return (long)MathUtils.clampFloor(amount - (seconds() - start), 0);
            }
            return -1;
        }

        public void setMode(byte mode) {
            if (running) throw new RuntimeException("setMode() cannot be called while countdown is running");
            this.mode = mode;
        }
    }

}
