package com.uk.stream.datasource;

public class Student {

    private int studentId;
    private String studentName;
    private int studentAge;

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public Student(int studentId, String studentName, int studentAge) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge + "]";
    }
}