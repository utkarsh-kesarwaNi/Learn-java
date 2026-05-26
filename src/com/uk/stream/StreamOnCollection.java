package com.uk.stream;

import com.uk.datasource.Student;

import java.util.Arrays;
import java.util.List;

public class StreamOnCollection {

    public static void main(String[] args) {
        Student damonSalvatore = new Student(101, "Damon Salvatore", 28);
        Student elenaGilbert = new Student(101, "Elena Gilbert", 27);
        Student niklaus = new Student(101, "Klaus Mikaelson", 33);
        Student stefanSalvatore = new Student(101, "Stefan Salvatore", 30);
        Student caroline = new Student(101, "Caroline Forbes", 29);

        List<Student> studentList = Arrays.asList(damonSalvatore, elenaGilbert, niklaus, stefanSalvatore, caroline);

        studentList.stream().filter(student -> student.getStudentAge() > 30)
                .forEach(student -> System.out.println(student.getStudentName()));
    }
}
