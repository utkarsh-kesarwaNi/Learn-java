package com.uk.parallelstreams;

import com.uk.datasource.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main() {

        System.out.println(Runtime.getRuntime().availableProcessors());

        long startTimeSequentialStream = System.currentTimeMillis();
        ParallelStream.getStudentList().stream().filter(student -> student.getStudentAge() > 30).forEach(System.out::println);
        long endTimeSequentialStream = System.currentTimeMillis();
        System.out.println("Time taken by sequential stream : " + (endTimeSequentialStream - startTimeSequentialStream));

        long startTimeParallelStream = System.currentTimeMillis();
//        Multiple threads are created automatically using Fork and join  framework
        ParallelStream.getStudentList().stream().parallel().filter(student -> student.getStudentAge() > 30).forEach(System.out::println);
        long endTimeParallelStream = System.currentTimeMillis();
        System.out.println("Time taken by parallel stream : " + (endTimeParallelStream - startTimeParallelStream));

//        forEachOrdered() performs an action on each element in the encounter order
        ParallelStream.getStudentList().stream().parallel().filter(student -> student.getStudentAge() > 30).forEachOrdered(System.out::println);
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
