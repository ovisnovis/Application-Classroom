import FileHandling.Checker;
import FileHandling.Reader;
import alumni.Course;
import alumni.Student;

import java.io.File;


public class ApplicationLauncher {
    public static void main(String[] args) {
        Checker checker = new Checker(new File("Files/major-map.txt"));
        Reader reader = new Reader(new File("Files/grades-v03.txt"), checker);
        if (reader.displayCourses().isPresent()) {
            Course course = reader.displayCourses().get();
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