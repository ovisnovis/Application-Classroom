import FileHandling.Reader;
import alumni.Student;

public class ApplicationLauncher {
    public static void main(String[] args) {
        for (Student student :
                Reader.readGradesV1()) {
            System.out.print("the average grade for " + student.getName());
            System.out.println(" is: " + student.getAvgGrades());
            }
    }

}