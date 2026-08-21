package com.uk.datasource;

public class Student {

    private final int studentId;
    private final String studentName;
    private final int studentAge;

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