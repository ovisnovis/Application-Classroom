package FileHandling;

import alumni.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.*;

public class Reader {
    static Scanner scanner;

    public static ArrayList<String> readGradesV1() {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("Files\\grades-v01.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        scanner.close();
        return dataList;
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

}
