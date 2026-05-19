import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("     STUDENT GRADE TRACKER");
        System.out.println("====================================");

        // Enter number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Arrays
        String[] names = new String[n];
        int[] marks = new int[n];
        String[] grades = new String[n];
        String[] results = new String[n];

        int total = 0;

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\n------------------------------------");
            System.out.println("Enter Details for Student " + (i + 1));
            System.out.println("------------------------------------");

            System.out.print("Enter Student Name : ");
            names[i] = sc.nextLine();

            System.out.print("Enter Student Marks : ");
            marks[i] = sc.nextInt();
            sc.nextLine();

            total += marks[i];

            // Grade Calculation
            if (marks[i] >= 90) {
                grades[i] = "A Grade";
            }
            else if (marks[i] >= 75) {
                grades[i] = "B Grade";
            }
            else if (marks[i] >= 50) {
                grades[i] = "C Grade";
            }
            else if (marks[i] >= 35) {
                grades[i] = "D Grade";
            }
            else {
                grades[i] = "Fail";
            }

            // Pass or Fail
            if (marks[i] >= 35) {
                results[i] = "PASS";
            } 
            else {
                results[i] = "FAIL";
            }
        }

        // Find highest and lowest
        int highest = marks[0];
        int lowest = marks[0];

        for (int i = 0; i < n; i++) {

            if (marks[i] > highest) {
                highest = marks[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        // Average Calculation
        double average = (double) total / n;

        // Console Report Generation
        System.out.println("\n\n====================================");
        System.out.println("         GENERATED REPORT");
        System.out.println("====================================");

        System.out.printf("%-15s %-10s %-10s %-10s\n",
                "NAME", "MARKS", "GRADE", "RESULT");

        System.out.println("------------------------------------------------");

        for (int i = 0; i < n; i++) {

            System.out.printf("%-15s %-10d %-10s %-10s\n",
                    names[i],
                    marks[i],
                    grades[i],
                    results[i]);
        }

        System.out.println("------------------------------------------------");

        System.out.println("Average Marks : " + average);
        System.out.println("Highest Marks : " + highest);
        System.out.println("Lowest Marks  : " + lowest);

        // Topper Details
        System.out.println("\nTopper(s):");

        for (int i = 0; i < n; i++) {

            if (marks[i] == highest) {

                System.out.println(
                        names[i] +
                        " scored highest marks : " + highest);
            }
        }

        // File Report Generation
        try {

            FileWriter writer = new FileWriter("report.txt");

            writer.write("========== STUDENT REPORT ==========\n\n");

            for (int i = 0; i < n; i++) {

                writer.write(
                        "Student Name : " + names[i] +
                        " | Marks : " + marks[i] +
                        " | Grade : " + grades[i] +
                        " | Result : " + results[i] + "\n");
            }

            writer.write("\nAverage Marks : " + average);
            writer.write("\nHighest Marks : " + highest);
            writer.write("\nLowest Marks  : " + lowest);

            writer.close();

            System.out.println(
                    "\nReport saved successfully in report.txt");

        }
        catch (IOException e) {

            System.out.println(
                    "Error saving report file.");
        }

        System.out.println("\n====================================");
        System.out.println("     REPORT GENERATED SUCCESSFULLY");
        System.out.println("====================================");

        sc.close();
    }
}