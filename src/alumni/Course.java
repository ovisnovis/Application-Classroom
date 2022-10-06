package alumni;

import java.util.ArrayList;

public class Course {
    private String id;
    private String name;

    private ArrayList<Student> assignedStudents = new ArrayList<>();

    public Course(String id, String name, ArrayList<Student> students) {
        setId(id);
        setName(name);
        setAssignedStudents(students);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignedStudents(ArrayList<Student> assignedStudents) {
        this.assignedStudents = assignedStudents;
    }
}
