package utils;

import java.io.*;
import java.util.ArrayList;
import models.SchoolClass;

public class FileUtil {
    // Save an ArrayList of SchoolClass objects to file
    public static void saveClasses(ArrayList<SchoolClass> classes, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(classes);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load an ArrayList of SchoolClass objects from file
    public static ArrayList<SchoolClass> loadClasses(String filename) {
        ArrayList<SchoolClass> classes = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            return classes;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            classes = (ArrayList<SchoolClass>) ois.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return classes;
    }
}
