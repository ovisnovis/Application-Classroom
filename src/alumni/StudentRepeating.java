package alumni;


public class StudentRepeating extends Student {

    public StudentRepeating(String name, String majorCode, double examGrade) {
        super(name, majorCode, examGrade);
    }

    public String toString() {
        return "The average grade for " + getName() + "* (" +
                getMajorCode() +
                ") is: " + getExamGrade();
    }

}