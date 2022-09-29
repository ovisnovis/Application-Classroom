package FileHandling;

import alumni.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    static Scanner scanner;
    static List<Student> studentList;

    public static void readGradesV1() {
        studentList = new ArrayList<>();
        List<String> dataList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("Files/grades-v01.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()){
            dataList.add(scanner.nextLine());
        }
        scanner.close();
        for (String who :
                dataList) {
            String[] split = who.split(",");
            Student student = new Student();
            student.setName(split[0]);
            for (int i = 1; i < split.length; i++) {
                try {
                    student.setGrades(Double.parseDouble(split[i]));
                } catch (NumberFormatException e) {
                    System.out.println("no valid number!");
                }
            }
        }
    }

    public static List<String> readGradesV2() {
        List<String> dataStringList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("Files/grades-v02.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()) dataStringList.add(scanner.nextLine());
        scanner.close();
        return dataStringList;
    }

    public static List<String> readMajorMap() {
        List<String> dataStringList = new ArrayList<>();
        try {
            scanner = new Scanner(new File("Files/major-map.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        while (scanner.hasNextLine()) dataStringList.add(scanner.nextLine());
        scanner.close();
        return dataStringList;
    }

}
