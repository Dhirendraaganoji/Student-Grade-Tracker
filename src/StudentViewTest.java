
import java.util.List;

public class StudentViewTest {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        List<Student> students = dao.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("===== ALL STUDENTS =====");

            for (Student student : students) {
                student.displayStudentDetails();
            }
        }
    }
}
