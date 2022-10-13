import FileHandling.Reader;
import alumni.Course;
import alumni.Student;


public class ApplicationLauncher {
    public static void main(String[] args) {
        if (Reader.displayCourses().isPresent()) {
            Course course = Reader.displayCourses().get();
            System.out.println("The number of students read: " + course.assignedStudents().size());
            System.out.println("Grades for " + course.name() + " (" + course.id() + ")");
            System.out.println("-------------------------------------------------------------");
            for (Student student :
                    course.assignedStudents()) {
                System.out.println("The average grade for " + student.getName() + " (" +
                        Reader.readMajors().get(student.getMajorCode()) +
                        ") is: " + student.averageStudent());
            }
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("Unable to read student data, sorry.");
        }

    }
//toString()
}