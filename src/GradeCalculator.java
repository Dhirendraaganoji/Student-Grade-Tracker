
public class GradeCalculator {

    // Calculate average marks
    public static double calculateAverage(double[] marks) {

        double total = 0;

        for (double mark : marks) {
            total = total + mark;
        }

        return total / marks.length;
    }

    // Find highest marks
    public static double findHighest(double[] marks) {

        double highest = marks[0];

        for (double mark : marks) {

            if (mark > highest) {
                highest = mark;
            }
        }

        return highest;
    }

    // Find lowest marks
    public static double findLowest(double[] marks) {

        double lowest = marks[0];

        for (double mark : marks) {

            if (mark < lowest) {
                lowest = mark;
            }
        }

        return lowest;
    }

    // Calculate grade
    public static String calculateGrade(double average) {

        if (average >= 90) {
            return "A";
        }
        else if (average >= 80) {
            return "B";
        }
        else if (average >= 70) {
            return "C";
        }
        else if (average >= 60) {
            return "D";
        }
        else {
            return "F";
        }
    }
}
