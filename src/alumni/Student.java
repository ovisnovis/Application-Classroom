package alumni;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private final String name;
    private final ArrayList<Double> grades;

    private final String majorCode;

    public Student(String name, String majorCode, ArrayList<Double> grades) {
        this.name = name;
        this.majorCode = majorCode;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Double> getGrade() {
        return grades;
    }


    public String getMajorCode() {
        return majorCode;
    }


    public String averageStudent() {
        Collections.sort(getGrade());
        getGrade().remove(0);
        double counter = 0;
        for (double i :
                getGrade()) {
            counter += i;
        }
        return df.format(counter / getGrade().size());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grades=" + grades +
                ", majorCode='" + majorCode + '\'' +
                '}';
    }
}