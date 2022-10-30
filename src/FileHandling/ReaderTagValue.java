package FileHandling;

import alumni.Course;
import alumni.Student;
import alumni.StudentRegular;
import alumni.StudentRepeating;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Double.parseDouble;


public class ReaderTagValue implements DataReader {
    private final File fileScn;

    public ReaderTagValue(File fileScn) {
        this.fileScn = fileScn;
    }

    @Override
    public File getFileScn() {
        return fileScn;
    }


    @Override
    public Optional<Course> displayCourses() {
        ArrayList<String> dataList = new ArrayList<>();
        ArrayList<Student> studentsList = new ArrayList<>();
        Scanner scanner;
        String stringSaver = "";
        String courseId = "^course-id:.*";
        String courseName = "^course-name:.*";
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
        Iterator<String> who = dataList.iterator();
        while (who.hasNext()) {
            String itrStr = who.next();
            if (itrStr.matches(courseId)) {
                courseId = itrStr.replaceAll("course-id:", "").trim();
                who.remove();
            } else if (itrStr.matches(courseName)) {
                courseName = itrStr.replaceAll("course-name:", "").trim();
                who.remove();
            } else stringSaver = stringSaver.concat(itrStr);
        }
        for (String s : stringSaver.split("(?=name:)")) {
            String name = s.substring(s.indexOf("name: ") + 6, s.indexOf("major"));
            String majorCode = s.substring(s.indexOf("major: ") + 7, s.indexOf("is_"));
            if (s.matches("(.*)true(.*)")) {
                studentsList.add(new StudentRepeating(
                        name,
                        majorCode,
                        parseDouble(s.substring(s.indexOf("exam-grade: ") + 12))));
            } else {
                ArrayList<Double> gradeList = new ArrayList<>();
                String saveGradeList = s.substring(s.indexOf("pre-grade: ") + 11);
                for (String s2 :
                        saveGradeList.split(",")) {
                    if (doubleChecker(s2)) {
                        gradeList.add(parseDouble(s2));
                    }
                }
                studentsList.add(new StudentRegular(
                        name,
                        majorCode,
                        parseDouble(s.substring(s.indexOf("exam-grade: ") + 12, s.indexOf("pre-"))),
                        gradeList));
            }
        }

        return Optional.of(new Course(courseId, courseName, studentsList));
    }

}
