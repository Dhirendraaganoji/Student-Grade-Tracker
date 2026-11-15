
import java.util.Scanner;

public class UpdateStudentTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Java Marks: ");
        double java = sc.nextDouble();

        System.out.print("Enter Python Marks: ");
        double python = sc.nextDouble();

        System.out.print("Enter SQL Marks: ");
        double sql = sc.nextDouble();

        System.out.print("Enter HTML Marks: ");
        double html = sc.nextDouble();

        System.out.print("Enter Computer Networks Marks: ");
        double networks = sc.nextDouble();

        dao.updateStudentMarks(
            id, java, python, sql, html, networks
        );

        sc.close();
    }
}
