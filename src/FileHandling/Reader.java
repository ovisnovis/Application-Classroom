package FileHandling;

import alumni.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Double.*;

public class Reader {
    static Scanner scanner;
    public static ArrayList<String> readGradesV1() {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("src/Files/grades-v01.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        scanner.close();
        return dataList;
    }

    public static ArrayList<String> readGradesV2() {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("src/Files/grades-v02.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        scanner.close();
        return dataList;
    }

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
            majorMap.put(split[0], split[1]);
        }
        return majorMap;
    }

    public static ArrayList<Student> displayStudents() {
        ArrayList<Student> studentsList = new ArrayList<>();
        for (String who : readGradesV1()) {
            String[] splitter = who.split(",");
            String name = "";
            ArrayList<Double> gradeList = new ArrayList<>();
            for (String insert :
                    splitter) {
                if (doubleChecker(insert)) {
                    gradeList.add(parseDouble(insert));
                } else {
                    name = insert;
                }
            }
            studentsList.add(new Student(name, gradeList));
        }
        return studentsList;
    }

    public static ArrayList<Student> displayStudentsMajors() {
        ArrayList<Student> studentsList = new ArrayList<>();
        for (String who : readGradesV2()) {
            String[] splitter = who.split(",");
            String name = "";
            String majorCode = "";
            ArrayList<Double> gradeList = new ArrayList<>();
            for (String insert :
                    splitter) {
                if (doubleChecker(insert)) {
                    gradeList.add(parseDouble(insert));
                } else if (readMajors().containsKey(insert.trim())) {
                    majorCode = insert.trim();
                } else {
                    name = insert;
                }
            }
            studentsList.add(new Student(name, majorCode, gradeList));
        }
        return studentsList;
    }

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
        for (Student student:
             checker) {
            if (student == null) {
                return false;
            }
        }
        return true;
    }

}
