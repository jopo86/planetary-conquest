package com.jopo.utils;

import java.util.HashMap;

public class RuntimeStats {

    private static final HashMap<String, String> map = new HashMap<>();

    private RuntimeStats() {};

    public static void addStat(String label, String value) {
        map.put(label, value);
    }

    public static void removeStat(String label) {
        map.remove(label);
    }

    public static String format() {
        StringBuilder str = new StringBuilder("\n\n------ RUNTIME STATS ------");
        for (int i = map.keySet().toArray().length - 1; i >= 0; i--) {
            str.append("\n").append(map.keySet().toArray()[i]).append(": ").append(map.values().toArray()[i]);
        }
        return str.toString();
    }

}