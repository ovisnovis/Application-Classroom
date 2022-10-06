package FileHandling;

import alumni.Student;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class Checker {

    public static boolean doubleChecker(String toCheck) {
        boolean bool;
        try {
            parseDouble(toCheck);
            bool = true;
        } catch (NumberFormatException e) {
            bool = false;
        }
        return bool;
    }

    public static boolean dataChecker(ArrayList<Student> checker) {
        for (Student student :
                checker) {
            if (student == null) {
                return false;
            }
        }
        return true;
    }
//    idChecker()
//    courseNameChecker()
//    nameChecker()
//    if","Checker/separator
}
