package alumni;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Hobos {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public String name;
    private List<Double> grade = new ArrayList<>();

    public Hobos(String name, ArrayList<Double> grade) {
        this.name = name;
        this.setGrade(grade);
    }

    public String averageHobo() {
        double counter = 0;
        for (double i :
                getGrade()) {
            counter += i;
        }
        return df.format(counter / getGrade().size());
    }

    public List<Double> getGrade() {
        return grade;
    }

    public void setGrade(List<Double> grade) {
        this.grade = grade;
    }
}

