package com.jopo.utils;

import java.io.*;

public class FileUtils {
    private FileUtils() {}

    public static void writeFile(String text, String filepath, boolean append) throws IOException {
        FileWriter writer = new FileWriter(filepath);
        if (append) writer.append(text);
        else writer.write(text);
        writer.close();
    }

    public static String readFile(String filepath) throws IOException {
        FileReader reader = new FileReader(filepath);
        StringBuilder str = new StringBuilder();
        for (int data = reader.read(); data != -1; data = reader.read()) {
            str.append((char)data);
        }
        return str.toString();
    }

    public static void serialize(Object obj, String filepath) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filepath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        fileOut.close();
        out.close();
    }

    public static Object deserialize(String filepath) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filepath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object obj = in.readObject();
        fileIn.close();
        in.close();
        return obj;
    }
}
