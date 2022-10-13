package FileHandling;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Checker {
    private final File fileScn;
    private Scanner scanner;

    public Checker(File fileScn) {
        this.fileScn = fileScn;
    }

    public File getFileScn() {
        return fileScn;
    }

    public HashMap<String, String> readMajors() {
        ArrayList<String> dataList = new ArrayList<>();
        HashMap<String, String> majorMap = new HashMap<>();
        try {
            scanner = new Scanner(getFileScn());
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
}
