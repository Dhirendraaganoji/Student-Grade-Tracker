
public class StudentDAOTest {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        Student student = new Student(
                9001,
                "Test Student",
                9001,
                85,
                90,
                88,
                92,
                86
        );

        dao.addStudent(student);
    }
}
