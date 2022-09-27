import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageGrade {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    static List<Student> classroom = new ArrayList<>();

    public static List<String> inputFile() {
        List<String> dataList = new ArrayList<>();
        try {
            Scanner scn = new Scanner(new File("grades-v01.txt"));
            while (scn.hasNextLine()) dataList.add(scn.nextLine());
            scn.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return dataList;
    }

    public static void dataSplit() {
        for (String student : inputFile()) {
            String[] who = student.split(",");
            double counter = 0;
            for (int i = 1; i < who.length; i++) {
                counter = counter + Double.parseDouble(who[i]);
            }
            Student kid = new Student(who[0], df.format(counter / (who.length - 1)));
            classroom.add(kid);
        }
    }

    public static void printStudents() {
        dataSplit();
        for (Student object : classroom
        ) {
            System.out.println("The average grade for " + object.name + " is: " + object.avgGrade);
        }
    }
}
