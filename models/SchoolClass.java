package models;

import java.io.Serializable;
import java.util.ArrayList;

public class SchoolClass implements Serializable {
    private String className;
    private ArrayList<Student> students;

    public SchoolClass(String className) {
        this.className = className;
        this.students = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    // Add a student to the class
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student by ID
    public boolean removeStudentById(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    // Display all students in the class
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in class " + className);
        } else {
            System.out.println("Students in class " + className + ":");
            for (Student s : students) {
                s.displayInfo();
                System.out.println("------------------------");
            }
        }
    }

    // Bonus: Calculate the average grade of all students in the class
    public double calculateClassAverage() {
        if (students.isEmpty()) return 0.0;
        double sum = 0.0;
        for (Student s : students) {
            sum += s.calculateAverage();
        }
        return sum / students.size();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
