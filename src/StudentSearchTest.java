
import java.util.Scanner;

public class StudentSearchTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student student = dao.searchStudent(id);

        if (student != null) {
            student.displayStudentDetails();
        } else {
            System.out.println("Student not found!");
        }

        sc.close();
    }
}
