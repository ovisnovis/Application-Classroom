package FileHandling;

import alumni.Course;
import alumni.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Double.*;

public class Reader {
    static Scanner scanner;

    public static HashMap<String, String> readMajors() {
        ArrayList<String> dataList = new ArrayList<>();
        HashMap<String, String> majorMap = new HashMap<>();
        try {
            scanner = new Scanner(new File("src/Files/major-map.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        scanner.close();
        for (String keyValue :
                dataList) {
            String[] split = keyValue.split("\t");
            majorMap.put(split[0].trim(), split[1].trim());
        }
        return majorMap;
    }


    public static Optional<Course> displayCourses() {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("src/Files/grades-v02b.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return Optional.empty();
        }
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        scanner.close();
        ArrayList<Student> studentsList = new ArrayList<>();
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
                    if (Checker.doubleChecker(insert)) {
                        gradeList.add(parseDouble(insert));
                    } else if (readMajors().containsKey(insert.trim())) {
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

}
