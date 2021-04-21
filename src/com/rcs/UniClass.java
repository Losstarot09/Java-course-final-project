package com.rcs;

import java.util.ArrayList;
import java.util.List;

public class UniClass {

    private final String name;
    private final List<Student> students;

    public UniClass (String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, String surname, String personalId) {
        this.students.add(new Student(name, surname, personalId));
    }

    public void showStudents() {
        int i = 0;
        for (Student student : this.students) {
            System.out.println(++i + ". " + student);
        }
    }

    public String getName() {
        return this.name;
    }

    public List<Student> getStudents() {
        return this.students;
    }
}
