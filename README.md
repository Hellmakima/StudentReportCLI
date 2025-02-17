# Student Report CLI

## Assumptions
- The CSV file follows a predefined format with columns: `Student ID, Name, Subject, Marks Obtained, Total Marks`.
- The first row of the CSV file contains headers and should be skipped.
- Marks are valid integers, and total marks are non-zero.
- The cutoff percentage for passing is fixed at 40% but can be modified in the code.

## Setup Instructions
1. Compile the Java source file:
   ```sh
   javac StudentReportCLI.java
   ```
2. Run the application with a CSV file:
   ```sh
   java StudentReportCLI <path-to-csv-file>
   ```
   Example:
   ```sh
   java StudentReportCLI students.csv
   ```

## Example CSV Format
```csv
Student ID, Name, Subject, Marks Obtained, Total Marks
101, John Doe, Mathematics, 35, 100
102, Jane Smith, Science, 85, 100
103, Alice Brown, English, 38, 50
```

## Example Output
```
Total Students Processed: 3
Passed: 2
Failed: 1

Failed Students:
- Student ID: 101, Name: John Doe, Subject: Mathematics, Marks: 35/100
```

## Error Handling
- Skips invalid rows (e.g., missing data, non-integer marks).
- Displays an error message if the file cannot be read.

---

For any issues or suggestions, feel free to contribute or raise an issue in the repository!

