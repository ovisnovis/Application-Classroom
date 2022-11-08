package FileHandling;

import alumni.Course;

import java.io.File;

public class ReaderFactory {
    private Course course;

    public ReaderFactory(File file) {
        if (file == null) {
            System.out.println("No file selected");
            this.course = new Course("","",null);
        } else if (file.getName().endsWith(".txt")) {
            ReaderTagValue readerTagValue = new ReaderTagValue(file);
            if (readerTagValue.displayCourses().isPresent()) {
                this.course = readerTagValue.displayCourses().get();
            }
        } else if (file.getName().endsWith(".csv")) {
            ReaderCSV readerCSV = new ReaderCSV(file);
            if (readerCSV.displayCourses().isPresent()) {
                this.course = readerCSV.displayCourses().get();
            }
        } else System.out.println("not known file type!");
    }

    public Course getCourse() {
        return course;
    }
}
