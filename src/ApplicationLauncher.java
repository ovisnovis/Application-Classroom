import FileHandling.Reader;
import alumni.Student;

import java.util.ArrayList;


public class ApplicationLauncher {
    public static void main(String[] args) {
        ArrayList<Student> studentsList = Reader.displayStudentsMajors();
        if (Reader.dataChecker(studentsList)) {
            System.out.println("The number of students read: " + studentsList.size());
            for (Student student :
                    studentsList) {
                System.out.println("The average grade for " + student.getName() + " (" +
                        Reader.readMajors().get(student.getMajorCode()) + ") " +
                        "is: " + student.averageStudent());
            }
        } else {
            System.out.println("Unable to read student data, sorry.");
        }
    }

}