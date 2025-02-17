import java.io.*;
import java.util.*;

class Student {
    String id, name, subject;
    int marksObtained, totalMarks;

    public Student(String id, String name, String subject, int marksObtained, int totalMarks) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.marksObtained = marksObtained;
        this.totalMarks = totalMarks;
    }

    public boolean isPassed() {
        return ((double) marksObtained / totalMarks) * 100 >= 40;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Subject: " + subject + ", Marks: " + marksObtained + "/" + totalMarks;
    }
}

public class StudentReportCLI {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java StudentReportCLI <csv-file-path>");
            return;
        }

        String filePath = args[0];
        List<Student> students = readCSV(filePath);

        if (students.isEmpty()) {
            System.out.println("No valid student records found.");
            return;
        }

        generateReport(students);
    }

    private static List<Student> readCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) continue;
                try {
                    students.add(new Student(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        Integer.parseInt(parts[3].trim()),
                        Integer.parseInt(parts[4].trim())
                    ));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid data: " + line);
                } catch (ArithmeticException e) {
                    System.out.println("Skipping invalid data: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return students;
    }

    private static void generateReport(List<Student> students) {
        int passed = 0, failed = 0;
        List<Student> failedStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.isPassed()) {
                passed++;
            } else {
                failed++;
                failedStudents.add(student);
            }
        }

        System.out.println("Total Students Processed: " + students.size());
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);

        if (!failedStudents.isEmpty()) {
            System.out.println("\nFailed Students:");
            for (Student student : failedStudents) {
                System.out.println("- " + student);
            }
        }
    }
}
