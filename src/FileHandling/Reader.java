package FileHandling;

import alumni.Hobos;
import alumni.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.*;

public class Reader {
    static Scanner scanner;

    public static ArrayList<Student> displayRead() {
        ArrayList<Student> studentList = new ArrayList<>();
        for (String who :
                readGradesV1()) {
            List<Double> gradeList = new ArrayList<>();
            String[] split = who.split(",");
            String hallo = split[0];
            for (int i = 1; i < split.length; i++) {
                try {
                    gradeList.add(parseDouble(split[i]));
                } catch (NumberFormatException e) {
                    System.out.println("no valid number!");
                }
                studentList.add(new Student(hallo, gradeList));
            }
        }
        return studentList;
    }

    public static ArrayList<String> readGradesV1() {
        ArrayList<String> dataList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("C:\\Users\\andre\\IdeaProjects\\Application-Classroom\\src\\Files\\grades-v01.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()) {
            dataList.add(scanner.nextLine());
        }
        scanner.close();
        return dataList;
    }

    public static ArrayList<Hobos> displayHobo() {
        ArrayList<Hobos> hobosList = new ArrayList<>();
        for (String who : readGradesV1()) {
            String[] spliter = who.split(",");
            String name = "";
            ArrayList<Double> gradeList = new ArrayList<>();
            for (String insert :
                    spliter) {
                if (doubleChecker(insert)) {
                    gradeList.add(parseDouble(insert));
                } else {
                    name = insert;
                }
            }
            hobosList.add(new Hobos(name, gradeList));
        }
        return hobosList;
    }

    public static boolean doubleChecker(String toCheck) {
        boolean bulli;
        try {
            parseDouble(toCheck);
            bulli = true;
        } catch (NumberFormatException e) {
            bulli = false;
        }
        return bulli;
    }

}
