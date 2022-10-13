import FileHandling.Checker;
import FileHandling.Reader;
import alumni.Course;
import alumni.Student;

import java.io.File;


public class ApplicationLauncher {
    public static void main(String[] args) {
        Checker checker = new Checker(new File("src/Files/major-map.txt"));
        Reader reader = new Reader(new File("src/Files/grades-v02b.txt"), checker);
        if (reader.displayCourses().isPresent()) {
            Course course = reader.displayCourses().get();
            System.out.println("The number of students read: " + course.assignedStudents().size());
            System.out.println("Grades for " + course.name() + " (" + course.id() + ")");
            System.out.println("-------------------------------------------------------------");

            for (Student student :
                    course.assignedStudents()) {
                System.out.println("The average grade for " + student.getName() + " (" +
                        checker.readMajors().get(student.getMajorCode()) +
                        ") is: " + student.averageStudent());
            }
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("Unable to read student data, sorry.");
        }

    }
}