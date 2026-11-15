
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Add student
    
public void addStudent(Student student) {

    String sql = "INSERT INTO students " +
            "(student_id, student_name, roll_number, java_marks, " +
            "python_marks, sql_marks, html_marks, computer_networks_marks) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    if (student.getStudentId() <= 0 ||
        student.getRollNumber() <= 0 ||
        student.getStudentName() == null ||
        student.getStudentName().trim().isEmpty()) {

        System.out.println("Invalid student details!");
        return;
    }

    double[] marks = {
        student.getJavaMarks(),
        student.getPythonMarks(),
        student.getSqlMarks(),
        student.getHtmlMarks(),
        student.getComputerNetworksMarks()
    };

    for (double mark : marks) {
        if (!Double.isFinite(mark) || mark < 0 || mark > 100) {
            System.out.println("Marks must be between 0 and 100!");
            return;
        }
    }

    try (Connection con = DatabaseConnection.getConnection()) {

        if (con == null) {
            System.out.println("Database connection unavailable!");
            return;
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getStudentName().trim());
            ps.setInt(3, student.getRollNumber());
            ps.setDouble(4, student.getJavaMarks());
            ps.setDouble(5, student.getPythonMarks());
            ps.setDouble(6, student.getSqlMarks());
            ps.setDouble(7, student.getHtmlMarks());
            ps.setDouble(8, student.getComputerNetworksMarks());

            ps.executeUpdate();

            System.out.println("Student saved successfully!");
        }

    } catch (SQLIntegrityConstraintViolationException e) {
        System.out.println("Student ID or Roll Number already exists!");

    } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
    }
    }


    // View all students
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection con = DatabaseConnection.getConnection()) {

            if (con == null) {
                System.out.println("Database connection unavailable!");
                return students;
            }

            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Student student = new Student(
                            rs.getInt("student_id"),
                            rs.getString("student_name"),
                            rs.getInt("roll_number"),
                            rs.getDouble("java_marks"),
                            rs.getDouble("python_marks"),
                            rs.getDouble("sql_marks"),
                            rs.getDouble("html_marks"),
                            rs.getDouble("computer_networks_marks")
                    );

                    students.add(student);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }

        return students;
    }

public Student searchStudent(int studentId) {

    String sql = "SELECT * FROM students WHERE student_id = ?";

    try (Connection con = DatabaseConnection.getConnection()) {

        if (con == null) {
            System.out.println("Database connection unavailable!");
            return null;
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Student(
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getInt("roll_number"),
                        rs.getDouble("java_marks"),
                        rs.getDouble("python_marks"),
                        rs.getDouble("sql_marks"),
                        rs.getDouble("html_marks"),
                        rs.getDouble("computer_networks_marks")
                    );
                }
            }

        }

    } catch (SQLException e) {
        System.out.println("Search error: " + e.getMessage());
    }

    return null;
}

public void updateStudentMarks(int studentId,
        double java, double python, double sql,
        double html, double networks) {

    String query = "UPDATE students SET java_marks=?, " +
            "python_marks=?, sql_marks=?, html_marks=?, " +
            "computer_networks_marks=? WHERE student_id=?";

    try (Connection con = DatabaseConnection.getConnection()) {

        if (con == null) {
            System.out.println("Database connection unavailable!");
            return;
        }

        try (PreparedStatement ps = con.prepareStatement(query)) {

            ps.setDouble(1, java);
            ps.setDouble(2, python);
            ps.setDouble(3, sql);
            ps.setDouble(4, html);
            ps.setDouble(5, networks);
            ps.setInt(6, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student marks updated successfully!");
            } else {
                System.out.println("Student not found!");
            }
        }

    } catch (SQLException e) {
        System.out.println("Update error: " + e.getMessage());
    }
}
public void deleteStudent(int studentId) {

    String sql = "DELETE FROM students WHERE student_id = ?";

    try (Connection con = DatabaseConnection.getConnection()) {

        if (con == null) {
            System.out.println("Database connection unavailable!");
            return;
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
        }

    } catch (SQLException e) {
        System.out.println("Delete error: " + e.getMessage());
    }
}
}
