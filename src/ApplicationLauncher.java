import FileHandling.Reader;
import alumni.Student;


public class ApplicationLauncher {
    public static void main(String[] args) {
        for (Student student :
                Reader.displayStudents()) {
            System.out.println("The average grade for " + student.getName() + " is: " + student.averageStudent());
        }
    }

}