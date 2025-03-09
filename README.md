# Student Management System

A basic Java-based Student Management System that allows users to create classes, add students, and perform CRUD (Create, Read, Update, Delete) operations on student records. This project uses a modular file structure to separate different concerns (models, services, utilities) for better organization and scalability.

## File Structure

StudentManagementSystem/ └── src/ ├── Main.java ├── models/ │ ├── Student.java │ └── SchoolClass.java ├── services/ │ └── ClassService.java └── utils/ └── FileUtil.java

pgsql
Copy
Edit

## Features

- **Create Classes:** Easily create new classes.
- **Student Management:** Add, update, display, and remove students from classes.
- **Grade Calculation:** Compute individual student averages and overall class average.
- **Data Persistence:** Save and load classes and student data using file serialization.
- **Number-Based Navigation:** Select classes via numbered menu options to minimize input errors.

## Requirements

- Java Development Kit (JDK) 8 or higher.
- A command-line interface or an IDE like Eclipse/IntelliJ IDEA for compiling and running the project.

## How to Compile and Run

1. **Open Terminal/Command Prompt and navigate to the `src` folder:**

   ```bash
   cd /path/to/StudentManagementSystem/src
Compile all Java files:

bash
Copy
Edit
javac Main.java models/*.java services/*.java utils/*.java
Run the Application:

bash
Copy
Edit
java Main
Usage
When you run the application, you'll see a menu with options like:

css
Copy
Edit
1. Create a new class
2. Add a student to a class
3. Display all classes
4. Display students in a class
5. Update student details
6. Remove a student from a class
7. Display class average grade
8. Save and Exit
For example, when choosing option 4, you'll be prompted to select a class from a numbered list (e.g., "1. Mathematics"). Just enter the number corresponding to the desired class to view its students.

## Contributions
Feel free to fork this project and submit pull requests if you want to add new features or fix bugs. Contributions are always welcome!
