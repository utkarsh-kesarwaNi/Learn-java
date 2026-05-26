package com.uk.parallelstreams;

import com.uk.datasource.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main() {

        long startTimeSequentialStream = System.currentTimeMillis();
        ParallelStream.getStudentList().forEach(System.out::println);
        long endTimeSequentialStream = System.currentTimeMillis();
        System.out.println("Time taken by sequential stream : " + (endTimeSequentialStream - startTimeSequentialStream));

        long startTimeParallelStream = System.currentTimeMillis();
//        Multiple threads are created automatically
        ParallelStream.getStudentList().stream().parallel().forEach(System.out::println);
        long endTimeParallelStream = System.currentTimeMillis();
        System.out.println("Time taken by parallel stream : " + (endTimeParallelStream - startTimeParallelStream));
    }

    public static List<Student> getStudentList() {

        Student damonSalvatore = new Student(101, "Damon Salvatore", 28);
        Student elenaGilbert = new Student(101, "Elena Gilbert", 27);
        Student niklaus = new Student(101, "Klaus Mikaelson", 33);
        Student stefanSalvatore = new Student(101, "Stefan Salvatore", 30);
        Student caroline = new Student(101, "Caroline Forbes", 29);

        return new ArrayList<>(Arrays.asList(damonSalvatore, elenaGilbert, niklaus, stefanSalvatore, caroline));
    }
}
