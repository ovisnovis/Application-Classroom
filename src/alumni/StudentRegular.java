package alumni;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class StudentRegular extends Student {

    private final DecimalFormat df = new DecimalFormat("#.##");

    private final double preGrade;
    public double preFactor = .3;


    public StudentRegular(String name, String majorCode, double examGrade, ArrayList<Double> grades) {
        super(name, majorCode, examGrade);
        Collections.sort(grades);
        grades.remove(0);
        double counter = 0;
        for (double dd :
                grades) {
            counter += dd;
        }
        this.preGrade = counter / grades.size();
    }

    public double getPreGrade() {
        return preGrade;
    }


    public String toString() {
        return "The average grade for " + getName() + " (" +
                getMajorCode() +
                ") is: " + df.format(getExamGrade());
    }

    public double getExamGrade() {
        return Double.parseDouble(df.format(super.getExamGrade() * (1 - preFactor) + getPreGrade() * preFactor));
    }

}