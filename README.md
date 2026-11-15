# Student Grade Tracker

## Project Overview

Student Grade Tracker is a Java-based console application used to manage student details and academic performance. It allows users to add, view, search, update and delete student records. It also calculates student grades and generates performance reports.

## Features

- Add new student records.
- View all student records.
- Search students using Student ID.
- Update student marks.
- Delete student records.
- Calculate total and average marks.
- Calculate grades based on average marks.
- Generate individual student performance reports.
- Generate class performance reports.
- Find the class topper.
- Store student information in a MySQL database.

## Technologies Used

- Java
- MySQL
- JDBC
- VS Code

## Subjects

The application manages marks for five subjects:

1. Java
2. Python
3. SQL
4. HTML
5. Computer Networks

## Project Structure

```text
CodeAlpha_StudentGradeTracker/
│
├── src/
│   ├── Main.java
│   ├── Student.java
│   ├── GradeCalculator.java
│   ├── StudentManager.java
│   ├── StudentDAO.java
│   ├── DatabaseConnection.java
│   └── DatabaseTest.java
│
├── lib/
│   └── mysql-connector-j-26.10.0.jar
│
├── README.md
└── .gitignore
```

## Database Setup

1. Install MySQL Server.
2. Create a database named `student_db`.
3. Create a table named `students`.
4. Configure the database connection in `DatabaseConnection.java`.

### Database Table

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    roll_number INT UNIQUE NOT NULL,
    java_marks DOUBLE NOT NULL,
    python_marks DOUBLE NOT NULL,
    sql_marks DOUBLE NOT NULL,
    html_marks DOUBLE NOT NULL,
    computer_networks_marks DOUBLE NOT NULL
);
```

## Database Configuration

1. Install MySQL Server.
2. Create the `student_db` database and `students` table.
3. Create a MySQL user named `studentapp` and grant it access to `student_db`.
4. Set the `DB_PASSWORD` environment variable to that user's password.

### macOS Terminal

```bash
export DB_PASSWORD='your_mysql_password'
```

### Compile the project

```bash
javac -cp "lib/*" src/*.java
```

### Run the application

```bash
java -cp "src:lib/*" Main
```

## How to Run

Open the terminal inside the project folder.

Compile the Java files:

```bash
javac -cp "lib/*" src/*.java
```

Run the application:

```bash
java -cp "src:lib/*" Main
```

## Learning Outcomes

- Understanding Java fundamentals and OOP concepts.
- Working with classes and objects.
- Using arrays and collections.
- Performing database operations using JDBC.
- Connecting Java applications with MySQL.
- Implementing CRUD operations.
- Calculating student grades and academic performance.

## Internship

**CodeAlpha – Java Programming Internship**

## Author

Student Grade Tracker Project developed as part of the CodeAlpha Java Programming Internship.
