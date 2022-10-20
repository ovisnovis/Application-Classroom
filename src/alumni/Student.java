package alumni;

public class Student {
    private final String majorCode;
    private final String name;
    private final double examGrade;

    public Student(String name, String majorCode, double examGrade) {
        this.majorCode = majorCode;
        this.name = name;
        this.examGrade = examGrade;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public String getName() {
        return name;
    }

    public double getExamGrade() {
        return examGrade;
    }

}
