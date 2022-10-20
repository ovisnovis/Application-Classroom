package alumni;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class StudentRegular extends Student {
    private final DecimalFormat df = new DecimalFormat("0.00");

    private final ArrayList<Double> grades;


    public StudentRegular(String name, String majorCode, double examGrade, ArrayList<Double> grades) {
        super(name, majorCode, examGrade);
        this.grades = grades;
    }

    public ArrayList<Double> getGrade() {
        return grades;
    }


    public String averageStudent() {
        Collections.sort(getGrade());
        getGrade().remove(0);
        double counter = 0;
        for (double i :
                getGrade()) {
            counter += i;
        }
        return df.format(counter / getGrade().size() * .3 + super.getExamGrade() * .7);
    }

    public String toString() {
        return "The average grade for " + getName() + " (" +
                getMajorCode() +
                ") is: " + averageStudent();
    }
}