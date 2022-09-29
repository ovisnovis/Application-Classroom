package alumni;

import java.text.DecimalFormat;
import java.util.List;

public class Student {
    /*save all grades and delete the least. no AverageGrade class.
    getter and setter. average and double control
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private String name;
    private List<Double> grades;
    public String avgGradeString ;

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades.add(grades);
    }
        public static void getAvgGrades() {
        }

}
