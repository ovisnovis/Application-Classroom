package FileHandling;

import alumni.Course;

import java.io.File;
import java.util.Optional;

import static java.lang.Double.parseDouble;

public interface DataReader {
    File getFileScn();
    Optional<Course> displayCourses();

    default boolean doubleChecker(String toCheck) {
        boolean bool;
        try {
            parseDouble(toCheck);
            bool = true;
        } catch (NumberFormatException e) {
            bool = false;
        }
        return bool;
    }

}
