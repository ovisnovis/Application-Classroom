import FileHandling.Checker;
import FileHandling.Reader;
import alumni.Course;
import alumni.Student;

import java.util.ArrayList;


public class ApplicationLauncher {
    public static void main(String[] args) {
        /*ArrayList<Student> studentsList = Reader.displayStudentsMajors();
        if (Checker.dataChecker(studentsList)) {
            System.out.println("The number of students read: " + studentsList.size());
            for (Student student :
                    studentsList) {
                System.out.println("The average grade for " + student.getName() + " (" +
                        Reader.readMajors().get(student.getMajorCode()) +
                        ") is: " + student.averageStudent());
            }
        } else {
            System.out.println("Unable to read student data, sorry.");
        }*/
        Course course = Reader.displayCourses().get();
        if (Reader.displayCourses().isPresent()) {
            System.out.println("The number of students read: " + course.getAssignedStudents().size());
            System.out.println("Grades for " + course.getName() + " (" + course.getId() + ")");
            System.out.println("-------------------------------------------------------------");
            for (Student student :
                    course.getAssignedStudents()) {
                System.out.println("The average grade for " + student.getName() + " (" +
                        Reader.readMajors().get(student.getMajorCode()) +
                        ") is: " + student.averageStudent());
            }
            System.out.println("-------------------------------------------------------------");
        }else {
            System.out.println("Unable to read student data, sorry.");
        }

    }

}