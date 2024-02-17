import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

public class ReadAndWriteData {
    public static void main(String[] args) {
        // Read data from Excel sheet
        
        List<Student> students = readDataFromExcel("src\\main\\resources\\data.xlsx");

        // Display data
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Method to read data from Excel sheet
    public static List<Student> readDataFromExcel(String fileName) {
        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(fileName));
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            // Iterate over rows
            for (Row row : sheet) {
                // Assuming columns are in order: Name, Courses, Fee
                String name = row.getCell(0).getStringCellValue();
                String courses = row.getCell(1).getStringCellValue();
                String fee = row.getCell(2).getStringCellValue();

                students.add(new Student(name, courses, fee));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    // Student class
    static class Student {
        private String name;
        private String courses;
        private String fee;

        public Student(String name, String courses, String fee) {
            this.name = name;
            this.courses = courses;
            this.fee = fee;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", courses='" + courses + '\'' +
                    ", fee='" + fee + '\'' +
                    '}';
        }
    }
}