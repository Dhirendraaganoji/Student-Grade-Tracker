
public class Student {

    private int studentId;
    private String studentName;
    private int rollNumber;

    private double javaMarks;
    private double pythonMarks;
    private double sqlMarks;
    private double htmlMarks;
    private double computerNetworksMarks;

    // Constructor
    public Student(int studentId, String studentName, int rollNumber,
                   double javaMarks, double pythonMarks,
                   double sqlMarks, double htmlMarks,
                   double computerNetworksMarks) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.rollNumber = rollNumber;

        this.javaMarks = javaMarks;
        this.pythonMarks = pythonMarks;
        this.sqlMarks = sqlMarks;
        this.htmlMarks = htmlMarks;
        this.computerNetworksMarks = computerNetworksMarks;
    }

    // Calculate total marks
    public double calculateTotal() {
        return javaMarks + pythonMarks + sqlMarks
                + htmlMarks + computerNetworksMarks;
    }

    // Calculate average
    public double calculateAverage() {
        return calculateTotal() / 5;
    }

    // Get student ID
    public int getStudentId() {
        return studentId;
    }

    // Get student name
    public String getStudentName() {
        return studentName;
    }

    // Get roll number
    public int getRollNumber() {
        return rollNumber;
    }

    // Get average
    public double getAverage() {
        return calculateAverage();
    }

    // Display student details
    public void displayStudentDetails() {

        System.out.println("\n===== STUDENT DETAILS =====");

        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);

        System.out.println("\n===== SUBJECT MARKS =====");

        System.out.println("Java: " + javaMarks);
        System.out.println("Python: " + pythonMarks);
        System.out.println("SQL: " + sqlMarks);
        System.out.println("HTML: " + htmlMarks);
        System.out.println("Computer Networks: " + computerNetworksMarks);

        System.out.println("\nTotal: " + calculateTotal());
        System.out.println("Average: " + calculateAverage());
    }
    public double getJavaMarks() {
    return javaMarks;
}

public double getPythonMarks() {
    return pythonMarks;
}

public double getSqlMarks() {
    return sqlMarks;
}

public double getHtmlMarks() {
    return htmlMarks;
}

public double getComputerNetworksMarks() {
    return computerNetworksMarks;
}
}
