package FileHandling;

import alumni.Course;
import alumni.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Double.*;

public class Reader {
    private File fileScn;

    public File getFileScn() {
        return fileScn;
    }

    public Reader(File fileScn) {
        this.fileScn = fileScn;
    }

    static Scanner scanner;


    public Optional<Course> displayCourses() {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            scanner = new Scanner(getFileScn());
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return Optional.empty();
        }
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        scanner.close();
        ArrayList<Student> studentsList = new ArrayList<>();
        Checker checker = new Checker(new File("src/Files/major-map.txt"));
        String courseName = "";
        String courseId = "";
        for (String who : dataList) {
            String[] splitter = who.split(",");
            String name = "";
            String majorCode = "";
            ArrayList<Double> gradeList = new ArrayList<>();
            if (splitter.length != 1) {
                for (String insert :
                        splitter) {
                    if (doubleChecker(insert)) {
                        gradeList.add(parseDouble(insert));
                    } else if (checker.readMajors().containsKey(insert.trim())) {
                        majorCode = insert.trim();
                    } else if (insert.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+")) {
                        name = insert.trim();
                    }
                }
                studentsList.add(new Student(name, majorCode, gradeList));
            } else if (who.trim().matches("[a-zA-Z]+\\p{P}[a-zA-Z]+\\p{P}[a-zA-Z]+\\s\\d*")) {
                courseId = who.trim();
            } else courseName = who.trim();
        }
        return Optional.of(new Course(courseId, courseName, studentsList));
    }
    private static boolean doubleChecker(String toCheck) {
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
