package models;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private double[] grades;

    public Student(int id, String name, int age, double[] grades) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    // Getters for id and name
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    // Setters for name, age, and grades
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    // Calculate average grade of the student
    public double calculateAverage() {
        if (grades == null || grades.length == 0) return 0.0;
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Display student details
    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grades: " + Arrays.toString(grades));
        System.out.println("Average Grade: " + calculateAverage());
    }
}
