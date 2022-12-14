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
            } else stringSaver = stringSaver.concat(itrStr + " ");
        }
        Scanner scnTwo;
        for (String stringItr :
                stringSaver.split("(?=name:)")) {
            scnTwo = new Scanner(stringItr);
            String name = stringItr
                    .substring(stringItr.indexOf("name: ") + 6, stringItr.indexOf("major")-1);
            String majorCode = scnTwo.findInLine("(?<=major: )\\w{2}");
            double examGrade = parseDouble(scnTwo.findInLine("(?<=exam-grade: )\\d\\.*\\d*")
                    .replaceAll("exam-grade: ", ""));
            if (stringItr.matches("(.*)true(.*)")) {
                studentsList.add(new StudentRepeating(name, majorCode, examGrade));
            } else {
                ArrayList<Double> gradeList = new ArrayList<>();
                String saveGradeList = scnTwo.findInLine("(?<=pre-grade: ).*");
                for (String s2 :
                        saveGradeList.split(",")) {
                    if (doubleChecker(s2.trim())) {
                        gradeList.add(parseDouble(s2.trim()));
                    }
                }
                studentsList.add(new StudentRegular(name, majorCode, examGrade, gradeList));
            }
        }
        return Optional.of(new Course(courseId, courseName, studentsList));
    }
}
