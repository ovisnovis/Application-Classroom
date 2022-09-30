package alumni;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    /*save all grades and delete the least. no AverageGrade class.
    getter and setter. average and double control
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static String name;
    public static List<Double> grades = new ArrayList<>();

    public Student() {
    }

    public String getName() {
        return Student.name;
    }

    public void setName(String name) {
        Student.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(double num) {
        this.grades.add(num);
    }

    public static String getAvgGrades() {
        Collections.sort(grades);
        grades.remove(0);
        double iter = 0;
        for (double number :
                grades) {
            iter += number;
        }
        return df.format(iter / grades.size());
    }

}
