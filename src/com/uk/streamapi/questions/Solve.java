package com.uk.streamapi.questions;

import com.uk.datasource.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Solve {
    static void main() {

        List<Integer> firstListOfIntegers = Arrays.asList(4, 5, 21, 21, 0, 21, 13, 20, 13, 4, 5, 9);
        List<Integer> secondListOfIntegers = Arrays.asList(4, 15, 21, 21, 10, 21, 13, 20, 13, 14, 15, 9);
        List<String> listOfStrings = Arrays.asList("My name", "is", "Utkarsh", "Kesarwani");

        List<List<Integer>> nestedListOfIntegers = Arrays.asList(
                firstListOfIntegers,
                secondListOfIntegers
        );

        List<Employee> listOfEmployees = Arrays.asList(
                new Employee("Damon", "Occult", 69_000L),
                new Employee("Stefan", "Armory", 44_000L),
                new Employee("Klaus", "The Original", 77_000L),
                new Employee("Elijah", "The Original", 49_600L),
                new Employee("Caroline", "Occult", 50_500L),
                new Employee("Matt", "Sergeant", 20_450L),
                new Employee("Katherine", "Occult", 48_500L),
                new Employee("Jeremy", "Hunter", 50_000L),
                new Employee("Rayna Cruz", "Hunteress", 50_000L),
                new Employee("Tyler Lockwood", "Werewolf", 50_000L)
        );

        System.out.println(getUniqueDescending(firstListOfIntegers));

        System.out.println(getSquaredOddNumbers(firstListOfIntegers));

        System.out.println(getSecondAndThirdElements(firstListOfIntegers));

        System.out.println(getSecondLargestNumber(firstListOfIntegers).isPresent() ? getSecondLargestNumber(firstListOfIntegers).get() : -1);

        System.out.println(partitionEvensAndOdds(firstListOfIntegers));

        System.out.println(findLongestString(listOfStrings).isPresent() ? findLongestString(listOfStrings).get() : -1);

        System.out.println(findFirstEmployeeWithSalaryOver50k(listOfEmployees).isPresent() ? findFirstEmployeeWithSalaryOver50k(listOfEmployees).get() : -1);

        System.out.println(getTopTwoHighestPaidEmployees(listOfEmployees));

        System.out.println(sortEmployeesBySalaryThenName(listOfEmployees));

        System.out.println(countOccurrences(firstListOfIntegers));

        System.out.println(countEmployeesByDepartment(listOfEmployees));

        System.out.println(calculateTotalSalaryByDepartment(listOfEmployees));

        System.out.println(getAverageSalaryByDepartment(listOfEmployees));

        System.out.println(getHighestPaidEmployeeByDepartment(listOfEmployees));

        System.out.println(getEmployeeNamesAsCommaSeparatedString(listOfEmployees));

        System.out.println(getCommonElements(firstListOfIntegers, secondListOfIntegers));

        System.out.println(flattenAndGetUnique(nestedListOfIntegers));
    }

    /*
     * Remove duplicates and sort in descending order
     */
    private static List<Integer> getUniqueDescending(List<Integer> listOfIntegers) {
        return listOfIntegers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    /*
     * Filter odd numbers and return square for each one of them
     */
    private static List<Integer> getSquaredOddNumbers(List<Integer> listOfIntegers) {
        return listOfIntegers.stream()
                .filter(x -> ((x & 1) == 1))
                .map(x -> x * x)
                .toList();
    }

    /*
     * Get second and third element
     */
    private static List<Integer> getSecondAndThirdElements(List<Integer> listOfIntegers) {
        return listOfIntegers.stream()
                .skip(1)
                .limit(2)
                .toList();
    }

    /*
     * Get second-largest number in the list
     */
    private static Optional<Integer> getSecondLargestNumber(List<Integer> listOfIntegers) {
        return listOfIntegers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1).findFirst();
//                .limit(1).toList().getFirst();
    }

    /*
     * Divide the numbers into 2 lists of even and odd
     */
    private static Map<Boolean, List<Integer>> partitionEvensAndOdds(List<Integer> listOfIntegers) {
        return listOfIntegers.stream()
                .collect(Collectors.partitioningBy(x -> (x & 1) == 0));
    }

    /*
     * Return the longest string from a list of strings
     */
    private static Optional<String> findLongestString(List<String> listOfStrings) {
        return listOfStrings.stream()
                .max(Comparator.comparing(String::length));
    }

    /*
     * Get first employee with salary more than 50000
     */
    private static Optional<Employee> findFirstEmployeeWithSalaryOver50k(List<Employee> listOfEmployees) {
        return listOfEmployees.stream()
                .filter(employee -> employee.getEmployeeSalary() > 50000)
                .findFirst();
    }

    /*
     * Get top 2 highest paid employees
     */
    private static List<Employee> getTopTwoHighestPaidEmployees(List<Employee> listOfEmployees) {
        return listOfEmployees.stream()
                .sorted(Comparator.comparingLong(employee -> -1 * employee.getEmployeeSalary()))
                .limit(2).toList();
    }

    /*
     * Sort employees by salary and then by name
     */
    private static List<Employee> sortEmployeesBySalaryThenName(List<Employee> listOfEmployees) {
        return listOfEmployees.stream()
                .sorted((employeeOne, employeeTwo) -> {
                    if (employeeOne.getEmployeeSalary() > employeeTwo.getEmployeeSalary()) return 1;
                    else if (employeeOne.getEmployeeSalary() < employeeTwo.getEmployeeSalary()) return -1;
                    else return employeeOne.getEmployeeName().compareTo(employeeTwo.getEmployeeName());
                }).toList();
    }

    /*
     * Find frequency of each element in a given list
     */
    private static Map<Integer, Long> countOccurrences(List<Integer> listOfIntegers) {
        return listOfIntegers.stream()
                .collect(Collectors.groupingBy(element -> element, Collectors.counting()));
    }

    /*
     * Count employees in each department
     */
    private static Map<String, Long> countEmployeesByDepartment(List<Employee> listOfEmployees) {
        return listOfEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getEmployeeDepartment, Collectors.counting()));
    }

    /*
     * Total salary paid for each department
     */
    private static Map<String, Long> calculateTotalSalaryByDepartment(List<Employee> listOfEmployees) {
        return listOfEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getEmployeeDepartment, Collectors.summingLong(Employee::getEmployeeSalary)));
    }

    /*
     * Get average salary paid in each department
     */
    private static Map<String, Double> getAverageSalaryByDepartment(List<Employee> listOfEmployees) {
        return listOfEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getEmployeeDepartment, Collectors.averagingLong(Employee::getEmployeeSalary)));
    }

    /*
     * Get highest paid employee in each department
     */
    private static Map<String, Optional<Employee>> getHighestPaidEmployeeByDepartment(List<Employee> listOfEmployee) {
        return listOfEmployee.stream()
                .collect(Collectors.groupingBy(Employee::getEmployeeDepartment, Collectors.maxBy(Comparator.comparingLong(Employee::getEmployeeSalary))));
    }

    /*
     * Convert list of employees into comma-separated string of employee names
     */
    private static String getEmployeeNamesAsCommaSeparatedString(List<Employee> listOfEmployees) {
        return listOfEmployees.stream()
                .map(Employee::getEmployeeName)
                .collect(Collectors.joining(","));
    }

    /*
     * Get common elements between 2 lists of integers
     */
    private static List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return secondList.stream()
                .filter(firstList::contains)
                .toList();
    }

    /*
     * Convert list of lists into a single list of integers, remove duplicates if any
     */
    private static List<Integer> flattenAndGetUnique(List<List<Integer>> nestedListOfIntegers) {
        return nestedListOfIntegers.stream()
                .flatMap(Collection::stream)
                .distinct().toList();
    }

}
