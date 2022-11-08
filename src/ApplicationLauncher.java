import FileHandling.ReaderCSV;
import FileHandling.ReaderTagValue;
import alumni.Course;
import alumni.Student;

import java.io.File;
import java.util.Scanner;


public class ApplicationLauncher {
    public static void main(String[] args) {
        ReaderCSV readerCSV = new ReaderCSV(new File("Files/grades-v04.csv"));
        ReaderTagValue readerTagValue = new ReaderTagValue(new File("Files/grades-v04.txt"));
        Scanner choose = new Scanner(System.in);
        System.out.print("enter '1' for the CSV and '2' for the TVF: ");
        String input = choose.nextLine();
        if (input.equals("1")) {
            if (readerCSV.displayCourses().isPresent()) {
                Course course = readerCSV.displayCourses().get();
                System.out.println("The number of students read: " + course.assignedStudents().size());
                System.out.println("Grades for " + course.name() + " (" + course.id() + ")");
                System.out.println("-------------------------------------------------------------");

                for (Student student :
                        course.assignedStudents()) {
                    System.out.println(student);
                }
                System.out.println("-------------------------------------------------------------");
            } else {
                System.out.println("Unable to read student data, sorry.");
            }
        } else {
            if (readerTagValue.displayCourses().isPresent()) {
                Course course = readerTagValue.displayCourses().get();
                System.out.println("The number of students read: " + course.assignedStudents().size());
                System.out.println("Grades for " + course.name() + " (" + course.id() + ")");
                System.out.println("-------------------------------------------------------------");

                for (Student student :
                        course.assignedStudents()) {
                    System.out.println(student);
                }
                System.out.println("-------------------------------------------------------------");
            } else {
                System.out.println("Unable to read student data, sorry.");
            }
        }
    }

}