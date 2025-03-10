![Banner](https://private-user-images.githubusercontent.com/74038190/241765440-80728820-e06b-4f96-9c9e-9df46f0cc0a5.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDE1NjUzNDQsIm5iZiI6MTc0MTU2NTA0NCwicGF0aCI6Ii83NDAzODE5MC8yNDE3NjU0NDAtODA3Mjg4MjAtZTA2Yi00Zjk2LTljOWUtOWRmNDZmMGNjMGE1LmdpZj9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTAzMTAlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwMzEwVDAwMDQwNFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTZmMDM5ZmQzZjk5ZjYwMjE0MWZhYWZmYTQ0MjQyNTcyMDliZDA5OTUzMmM5ZmQyZmRjMjRjYzBkYWNlNGNjN2QmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.909u-zAsybfQcTJNai-VxvV43E3kRf3MiGZLTVR0Zqk)

# Student Management System

A basic Java-based Student Management System that allows users to create classes, add students, and perform CRUD (Create, Read, Update, Delete) operations on student records. This project uses a modular file structure to separate different concerns (models, services, utilities) for better organization and scalability.

## File Structure

```
StudentManagementSystem/
└── src/
    ├── Main.java
    ├── models/
    │   ├── Student.java
    │   └── SchoolClass.java
    ├── services/
    │   └── ClassService.java
    └── utils/
        └── FileUtil.java
```

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

1. **Open Terminal/Command Prompt and navigate to the `StudentManagementSystem` folder:**

   ```bash
   cd /path/to/StudentManagementSystem/
   ```

2. **Compile all Java files:**

   ```bash
   javac Main.java models/*.java services/*.java utils/*.java
   ```

3. **Run the Application:**

   ```bash
   java Main
   ```

## Usage

When you run the application, you'll see a menu with options like:

```
1. Create a new class
2. Add a student to a class
3. Display all classes
4. Display students in a class
5. Update student details
6. Remove a student from a class
7. Display class average grade
8. Save and Exit
```

For example, when choosing option **4**, you'll be prompted to select a class from a numbered list (e.g., "1. Mathematics"). Just enter the number corresponding to the desired class to view its students.

## Contributions

Feel free to fork this project and submit pull requests if you want to add new features or fix bugs. Contributions are always welcome!

