package alumni;

import java.util.ArrayList;
import java.util.Objects;

public final class Course {
    private final String id;
    private final String name;
    private final ArrayList<Student> assignedStudents;

    public Course(String id, String name, ArrayList<Student> assignedStudents) {
        this.id = id;
        this.name = name;
        this.assignedStudents = assignedStudents;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public ArrayList<Student> assignedStudents() {
        return assignedStudents;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Course) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.assignedStudents, that.assignedStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, assignedStudents);
    }

    @Override
    public String toString() {
        return "Course[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "assignedStudents=" + assignedStudents + ']';
    }


}
