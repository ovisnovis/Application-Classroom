package guiFX;

import alumni.Course;
import alumni.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StateModel {
    private Course course;
    List<StateObserver> observers;

    public StateModel() {
        observers = new ArrayList<>();
    }

    public void setCourse(Course course) {
        this.course = course;
        this.course.assignedStudents().sort(Comparator.comparing(Student::getName));
        sendStateChangedEvent();
    }

    public Course getCourse() {
        return course;
    }

    public void sorted(boolean sort) {
        if (!sort) this.course.assignedStudents().sort(Comparator.comparing(Student::getName));
        sendStateChangedEvent();
    }

    public void addObserver(StateObserver observer) {
        observers.add(observer);
    }

    private void sendStateChangedEvent() {
        for (StateObserver observer : observers) observer.stateChanged();
    }
}
