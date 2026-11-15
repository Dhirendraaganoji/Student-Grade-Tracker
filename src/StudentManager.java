
import java.util.ArrayList;

public class StudentManager {

    // Store student objects
    private ArrayList<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student student) {

        students.add(student);

        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n===== ALL STUDENTS =====");

        for (Student student : students) {
            student.displayStudentDetails();
        }
    }

    // Search student by ID
    public void searchStudent(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {

                System.out.println("Student found!");
                student.displayStudentDetails();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete student
    public void deleteStudent(int id) {

        for (Student student : students) {

            if (student.getStudentId() == id) {

                students.remove(student);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update student marks
    public void updateStudent(int id, double[] marks) {

        for (Student student : students) {

            if (student.getStudentId() == id) {

                if (marks.length != 5) {
                    System.out.println("Enter exactly 5 marks.");
                    return;
                }

                for (double mark : marks) {
                    if (mark < 0 || mark > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        return;
                    }
                }

                Student updatedStudent = new Student(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getRollNumber(),
                    marks[0],
                    marks[1],
                    marks[2],
                    marks[3],
                    marks[4]
                );

                students.set(students.indexOf(student), updatedStudent);

                System.out.println("Student marks updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}
