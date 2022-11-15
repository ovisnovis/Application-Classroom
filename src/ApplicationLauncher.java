import FileHandling.ReaderFactory;
import alumni.Course;

import java.io.File;


public class ApplicationLauncher {
    public static void main(String[] args) {
        Course course = new ReaderFactory(new File("Files/grades-v04.csv")).getCourse();
        System.out.println("The number of students read: " + course.assignedStudents().size());
        System.out.println("Grades for " + course.name() + " (" + course.id() + ")");
        System.out.println("-------------------------------------------------------------");
        course.assignedStudents().forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
    }
}