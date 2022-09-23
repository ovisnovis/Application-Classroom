import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageGrade {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static List<String> inputFile() {
        List<String> dataList = new ArrayList<>();
        try {
            File textFile = new File("grades-v01.txt");
            Scanner scn = new Scanner(textFile);
            while (scn.hasNextLine()) {
                dataList.add(scn.nextLine());
            }
            scn.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return dataList;
    }
    public static void dataSplit(){
        for (String student: inputFile()) {
            String[] who = student.split(",");
            double counter = 0;
            int nameCounter = 0;
            for (int i = 1; i < who.length; i++) {
                counter = counter+Double.parseDouble(who[i]);
            }
            System.out.print("The average grade for "+who[nameCounter]+" is: ");
            System.out.println(df.format(counter/(who.length-1)));
            counter = 0;
            nameCounter++;
        }
    }
}
