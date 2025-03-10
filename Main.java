import java.util.ArrayList;
import java.util.Scanner;
import models.SchoolClass;
import models.Student;
import services.ClassService;
import utils.FileUtil;

public class Main {
    private static final String DATA_FILE = "classes.dat";
    private static Scanner scanner = new Scanner(System.in);
    private static ClassService classService = new ClassService();

    public static void main(String[] args) {
        // Load saved data on program start
        ArrayList<SchoolClass> loadedClasses = FileUtil.loadClasses(DATA_FILE);
        if (!loadedClasses.isEmpty()) {
            for (SchoolClass sc : loadedClasses) {
                classService.addClass(sc);
            }
        }

        System.out.println("Welcome to the Student Management System!");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a new class");
            System.out.println("2. Add a student to a class");
            System.out.println("3. Display all classes");
            System.out.println("4. Display students in a class");
            System.out.println("5. Update student details");
            System.out.println("6. Remove a student from a class");
            System.out.println("7. Display class average grade");
            System.out.println("8. Save and Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createNewClass();
                    break;
                case 2:
                    addStudentToClass();
                    break;
                case 3:
                    displayAllClasses();
                    break;
                case 4:
                    displayStudentsInClass();
                    break;
                case 5:
                    updateStudentDetails();
                    break;
                case 6:
                    removeStudentFromClass();
                    break;
                case 7:
                    displayClassAverageGrade();
                    break;
                case 8:
                    FileUtil.saveClasses(classService.getClasses(), DATA_FILE);
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }

    // ----------------------
    //     HELPER METHODS
    // ----------------------

    /**
     * Display all available classes with a number, then let the user pick one.
     * @return the chosen SchoolClass, or null if invalid/no classes exist.
     */
    private static SchoolClass pickClass() {
        ArrayList<SchoolClass> classList = classService.getClasses();
        if (classList.isEmpty()) {
            System.out.println("No classes available. Please create a class first.");
            return null;
        }
        System.out.println("\nSelect a class:");
        for (int i = 0; i < classList.size(); i++) {
            System.out.println((i + 1) + ". " + classList.get(i).getClassName());
        }
        System.out.print("Enter the number of the class: ");
        int classIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (classIndex < 0 || classIndex >= classList.size()) {
            System.out.println("Invalid class number.");
            return null;
        }
        return classList.get(classIndex);
    }

    // ----------------------
    //     MENU HANDLERS
    // ----------------------

    private static void createNewClass() {
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        SchoolClass newClass = new SchoolClass(className);
        classService.addClass(newClass);
        System.out.println("Class created successfully.");
    }

    private static void addStudentToClass() {
        SchoolClass sc = pickClass();
        if (sc == null) return; // No valid class selected

        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter number of grades: ");
        int numGrades = Integer.parseInt(scanner.nextLine());
        double[] grades = new double[numGrades];
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = Double.parseDouble(scanner.nextLine());
        }

        Student student = new Student(id, name, age, grades);
        sc.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void displayAllClasses() {
        ArrayList<SchoolClass> classList = classService.getClasses();
        if (classList.isEmpty()) {
            System.out.println("No classes have been created yet.");
        } else {
            System.out.println("Available classes:");
            for (SchoolClass schoolClass : classList) {
                System.out.println("- " + schoolClass.getClassName());
            }
        }
    }

    private static void displayStudentsInClass() {
        SchoolClass sc = pickClass();
        if (sc == null) return;
        sc.displayStudents();
    }

    private static void updateStudentDetails() {
        SchoolClass sc = pickClass();
        if (sc == null) return;

        System.out.print("Enter student ID to update: ");
        int updateId = Integer.parseInt(scanner.nextLine());
        Student studentToUpdate = null;

        for (Student s : sc.getStudents()) {
            if (s.getId() == updateId) {
                studentToUpdate = s;
                break;
            }
        }

        if (studentToUpdate != null) {
            System.out.print("Enter new name (or press enter to skip): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                studentToUpdate.setName(newName);
            }

            System.out.print("Enter new age (or press enter to skip): ");
            String ageInput = scanner.nextLine();
            if (!ageInput.isEmpty()) {
                studentToUpdate.setAge(Integer.parseInt(ageInput));
            }

            System.out.print("Do you want to update grades? (y/n): ");
            String updateGrades = scanner.nextLine();
            if (updateGrades.equalsIgnoreCase("y")) {
                System.out.print("Enter number of grades: ");
                int newNumGrades = Integer.parseInt(scanner.nextLine());
                double[] newGrades = new double[newNumGrades];
                for (int i = 0; i < newNumGrades; i++) {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    newGrades[i] = Double.parseDouble(scanner.nextLine());
                }
                studentToUpdate.setGrades(newGrades);
            }
            System.out.println("Student details updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudentFromClass() {
        SchoolClass sc = pickClass();
        if (sc == null) return;

        System.out.print("Enter student ID to remove: ");
        int removeId = Integer.parseInt(scanner.nextLine());
        boolean removed = sc.removeStudentById(removeId);
        if (removed) {
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayClassAverageGrade() {
        SchoolClass sc = pickClass();
        if (sc == null) return;

        double classAvg = sc.calculateClassAverage();
        System.out.println("Class average grade: " + classAvg);
    }
}
