
import java.util.Scanner;
import java.util.List;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("       STUDENT GRADE TRACKER");
            System.out.println("==================================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("7. Student Performance Report");
            System.out.println("8. Class Performance Report");

            System.out.println("==================================");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {

                case 1:
                    addStudent(dao);
                    break;

                case 2:
                    viewStudents(dao);
                    break;

                case 3:
                    searchStudent(dao);
                    break;

                case 4:
                    updateStudent(dao);
                    break;

                case 5:
                    deleteStudent(dao);
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using Student Grade Tracker!"
                    );
                    break;

                case 7:
                    studentPerformanceReport(dao);
                    break;

                case 8:
                    classPerformanceReport(dao);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    // Add student
    public static void addStudent(StudentDAO dao) {

        int id;

        do {
            System.out.print("Enter Student ID (positive number): ");
            id = readInt();

            if (id <= 0) {
                System.out.println(
                    "Student ID must be greater than zero!"
                );
            }

        } while (id <= 0);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        while (name.isEmpty()) {
            System.out.print(
                "Name cannot be empty. Enter Student Name: "
            );
            name = sc.nextLine().trim();
        }

        int roll;

        do {
            System.out.print("Enter Roll Number (positive number): ");
            roll = readInt();

            if (roll <= 0) {
                System.out.println(
                    "Roll Number must be greater than zero!"
                );
            }

        } while (roll <= 0);

        double[] marks = readMarks("Enter ");

        Student student = new Student(
            id, name, roll,
            marks[0], marks[1], marks[2],
            marks[3], marks[4]
        );

        dao.addStudent(student);
    }

    // View all students
    public static void viewStudents(StudentDAO dao) {

        List<Student> students = dao.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("\n===== ALL STUDENTS =====");

            for (Student student : students) {
                student.displayStudentDetails();
            }
        }
    }

    // Search student
    public static void searchStudent(StudentDAO dao) {

        System.out.print("Enter Student ID: ");
        int id = readInt();

        Student student = dao.searchStudent(id);

        if (student != null) {
            student.displayStudentDetails();
        } else {
            System.out.println("Student not found!");
        }
    }

    // Update student marks
    public static void updateStudent(StudentDAO dao) {

        System.out.print("Enter Student ID to update: ");
        int id = readInt();

        Student existingStudent = dao.searchStudent(id);

        if (existingStudent == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Enter the new marks:");

        double[] marks = readMarks("New ");

        dao.updateStudentMarks(
            id,
            marks[0],
            marks[1],
            marks[2],
            marks[3],
            marks[4]
        );
    }

    // Delete student
    public static void deleteStudent(StudentDAO dao) {

        System.out.print("Enter Student ID to delete: ");
        int id = readInt();

        Student student = dao.searchStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print(
            "Are you sure you want to delete "
            + student.getStudentName() + "? (yes/no): "
        );

        String confirmation = sc.nextLine().trim();

        if (confirmation.equalsIgnoreCase("yes")) {
            dao.deleteStudent(id);
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    // Student performance report
    public static void studentPerformanceReport(StudentDAO dao) {

        System.out.print("Enter Student ID: ");
        int id = readInt();

        Student student = dao.searchStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        double[] marks = {
            student.getJavaMarks(),
            student.getPythonMarks(),
            student.getSqlMarks(),
            student.getHtmlMarks(),
            student.getComputerNetworksMarks()
        };

        double average = GradeCalculator.calculateAverage(marks);
        double highest = GradeCalculator.findHighest(marks);
        double lowest = GradeCalculator.findLowest(marks);
        String grade = GradeCalculator.calculateGrade(average);

        System.out.println(
            "\n========== STUDENT PERFORMANCE REPORT =========="
        );

        System.out.println("Student ID   : " + student.getStudentId());
        System.out.println("Student Name : " + student.getStudentName());
        System.out.println("Roll Number  : " + student.getRollNumber());

        System.out.println("\nSubject Marks:");
        System.out.println("Java              : " + marks[0]);
        System.out.println("Python            : " + marks[1]);
        System.out.println("SQL               : " + marks[2]);
        System.out.println("HTML              : " + marks[3]);
        System.out.println("Computer Networks : " + marks[4]);

        System.out.println("\nAverage Marks : " + average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);
        System.out.println("Final Grade   : " + grade);

        System.out.println(
            "================================================="
        );
    }

    // Class performance report
    public static void classPerformanceReport(StudentDAO dao) {

        List<Student> students = dao.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No student records available!");
            return;
        }

        double totalAverage = 0;
        Student topper = students.get(0);

        for (Student student : students) {

            double average = student.getAverage();

            totalAverage += average;

            if (average > topper.getAverage()) {
                topper = student;
            }
        }

        double classAverage = totalAverage / students.size();

        System.out.println(
            "\n========== CLASS PERFORMANCE REPORT =========="
        );

        System.out.println("Total Students : " + students.size());
        System.out.println("Class Average  : " + classAverage);

        System.out.println("\n========== CLASS TOPPER ==========");
        System.out.println("Student Name : " + topper.getStudentName());
        System.out.println("Student ID   : " + topper.getStudentId());
        System.out.println("Roll Number  : " + topper.getRollNumber());
        System.out.println("Average      : " + topper.getAverage());

        System.out.println(
            "Grade        : " +
            GradeCalculator.calculateGrade(topper.getAverage())
        );

        System.out.println(
            "==============================================="
        );
    }

    // Read five subject marks
    public static double[] readMarks(String prefix) {

        double[] marks = new double[5];

        String[] subjects = {
            "Java", "Python", "SQL", "HTML", "Computer Networks"
        };

        for (int i = 0; i < marks.length; i++) {

            while (true) {

                System.out.print(prefix + subjects[i] + " Marks: ");

                marks[i] = readDouble();

                if (marks[i] >= 0 && marks[i] <= 100) {
                    break;
                }

                System.out.println(
                    "Marks must be between 0 and 100."
                );
            }
        }

        return marks;
    }

    // Read integer safely
    public static int readInt() {

        while (true) {

            try {
                return Integer.parseInt(sc.nextLine().trim());
            }
            catch (NumberFormatException e) {
                System.out.print(
                    "Please enter a valid number: "
                );
            }
        }
    }

    // Read decimal number safely
    public static double readDouble() {

        while (true) {

            try {
                double value = Double.parseDouble(
                    sc.nextLine().trim()
                );

                if (Double.isFinite(value)) {
                    return value;
                }

                System.out.print("Please enter a valid mark: ");
            }
            catch (NumberFormatException e) {
                System.out.print("Please enter a valid mark: ");
            }
        }
    }
}
