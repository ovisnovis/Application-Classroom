package alumni;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Student {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private String name;
    private ArrayList<Double> grades = new ArrayList<>();

    public Student(String newName, ArrayList<Double> newGrade) {
        this.setName(newName);
        this.setGrades(newGrade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
}

    public ArrayList<Double> getGrade() {
        return grades;
    }

    public void setGrades(ArrayList<Double> newGrade) {
        this.grades = newGrade;
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

}