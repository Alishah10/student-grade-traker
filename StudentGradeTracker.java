import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        // Create an ArrayList to store the student grades
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Student Grade Tracker!");

        // Loop to input grades
        while (true) {
            System.out.print("Enter a student's grade (or type 'done' to finish): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int grade = Integer.parseInt(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'done'.");
            }
        }

        // Close the scanner
        scanner.close();

        // Check if there are grades entered
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
            return;
        }

        // Calculate average, highest, and lowest grades
        int sum = 0;
        int highest = grades.get(0);
        int lowest = grades.get(0);

        for (int grade : grades) {
            sum += grade;
            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = (double) sum / grades.size();

        // Display the results
        System.out.println("\n--- Grade Summary ---");
        System.out.println("Total number of students: " + grades.size());
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
    }
}
