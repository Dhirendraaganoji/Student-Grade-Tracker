
import java.util.Scanner;

public class DeleteStudentTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        dao.deleteStudent(id);

        sc.close();
    }
}
