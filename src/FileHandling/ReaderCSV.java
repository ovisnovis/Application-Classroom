package FileHandling;

import alumni.Course;
import alumni.Student;
import alumni.StudentRegular;
import alumni.StudentRepeating;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class ReaderCSV implements DataReader {
    private final File fileScn;
    private final Checker checker;

    public ReaderCSV(File fileScn, Checker checker) {
        this.fileScn = fileScn;
        this.checker = checker;
    }

    public File getFileScn() {
        return fileScn;
    }


    public Optional<Course> displayCourses() {
        ArrayList<String> dataList = new ArrayList<>();
        Scanner scanner;
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
        String courseName = "";
        String courseId = "";
        for (String who : dataList) {
            String[] splitter = who.split(",");
            String name = "";
            String majorCode = "";
            double examGrade = 0;
            ArrayList<Double> gradeList = new ArrayList<>();
            if (4 == splitter.length) {
                for (String insert :
                        splitter) {
                    if (doubleChecker(insert.trim())) {
                        examGrade = parseDouble(insert);
                    } else if (checker.readMajors().containsKey(insert.trim())) {
                        majorCode = insert.trim();
                    } else if (insert.matches("^[A-ZÄÖÜ][a-zäöü]+\\s[A-ZÄÖÜ][a-zäöü]+")) {
                        name = insert.trim();
                    }
                }
                studentsList.add(new StudentRepeating(name, majorCode, examGrade));
            } else if (splitter.length > 4) {
                for (String insert :
                        splitter) {
                    if (doubleChecker(insert) && (examGrade == 0)) {
                        examGrade = parseDouble(insert);
                    } else if (doubleChecker(insert)) {
                        gradeList.add(parseDouble(insert));
                    } else if (checker.readMajors().containsKey(insert.trim())) {
                        majorCode = insert.trim();
                    } else if (insert.matches("^[A-ZÄÖÜ][a-zäöü]+\\s[A-ZÄÖÜ][a-zäöü]+")) {
                        name = insert.trim();
                    }
                }
                studentsList.add(new StudentRegular(name, majorCode, examGrade, gradeList));
            } else if (who.trim().matches("[a-zA-Z]+\\p{P}[a-zA-Z]+\\p{P}[a-zA-Z]+\\s\\d*")) {
                courseId = who.trim();
            } else courseName = who.trim();
        }
        return Optional.of(new Course(courseId, courseName, studentsList));
    }


}
