import FileHandling.Reader;
import alumni.Course;
import alumni.Student;


public class ApplicationLauncher {
    public static void main(String[] args) {
        Course course = Reader.displayCourses().get();
        if (Reader.displayCourses().isPresent()) {
            System.out.println("The number of students read: " + course.getAssignedStudents().size());
            System.out.println("Grades for " + course.getName() + " (" + course.getId() + ")");
            System.out.println("-------------------------------------------------------------");
            for (Student student :
                    course.getAssignedStudents()) {
                System.out.println("The average grade for " + student.getName() + " (" +
                        Reader.readMajors().get(student.getMajorCode()) +
                        ") is: " + student.averageStudent());
            }
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("Unable to read student data, sorry.");
        }

    }

}