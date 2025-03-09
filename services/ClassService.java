package services;

import java.util.ArrayList;
import models.SchoolClass;
import models.Student;

public class ClassService {
    private ArrayList<SchoolClass> classes;

    public ClassService() {
        classes = new ArrayList<>();
    }

    // Add a new class
    public void addClass(SchoolClass schoolClass) {
        classes.add(schoolClass);
    }

    // Retrieve the list of classes
    public ArrayList<SchoolClass> getClasses() {
        return classes;
    }

    // Find a class by name
    public SchoolClass getClassByName(String className) {
        for (SchoolClass sc : classes) {
            if (sc.getClassName().equalsIgnoreCase(className)) {
                return sc;
            }
        }
        return null;
    }

    // Remove a student from a specific class by student ID
    public boolean removeStudentFromClass(String className, int studentId) {
        SchoolClass sc = getClassByName(className);
        if (sc != null) {
            return sc.removeStudentById(studentId);
        }
        return false;
    }
}
