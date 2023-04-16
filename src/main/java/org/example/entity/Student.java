package org.example.entity;

//@Entity(name = "student_table")

import javax.persistence.*;

//==================================
//@Entity
//@Table(name = "student_table")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long studentID;
    @Column(name = "name", length = 45, nullable = false)
    private String studentName;
    private double marks;

    public Student(long studentID, String studentName, double marks) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.marks = marks;
    }

    public Student() {
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
