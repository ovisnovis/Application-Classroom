import java.text.DecimalFormat;

public class Student {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public String name;
    public double avgGrade;
    public String avgGradeString ;

    public Student(String name, double avgGrade) {
        this.name = name;
        this.avgGrade = avgGrade;
        this.avgGradeString = df.format(avgGrade);
    }
}
