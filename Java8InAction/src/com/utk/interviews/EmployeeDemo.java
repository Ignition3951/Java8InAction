package com.utk.interviews;

import com.utk.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDemo {

    public static void main(String[] args) {

        // Create a list of employees
        List<Employee> employees = List.of(
                new Employee(1, "Amit", "IT", "Developer", 60000, true, 28),
                new Employee(2, "Ravi", "IT", "Developer", 75000, true, 32),
                new Employee(3, "Neha", "IT", "Manager", 120000, true, 40),

                new Employee(4, "Pooja", "HR", "Recruiter", 45000, true, 26),
                new Employee(5, "Ankit", "HR", "Manager", 90000, false, 38),

                new Employee(6, "Suresh", "Finance", "Accountant", 55000, true, 35),
                new Employee(7, "Meena", "Finance", "Manager", 110000, true, 42),

                new Employee(8, "Rahul", "Sales", "Executive", 50000, true, 29),
                new Employee(9, "Kiran", "Sales", "Executive", 48000, false, 31),
                new Employee(10, "Sunita", "Sales", "Manager", 95000, true, 45)
        );

        // group by -> many keys
        Map<String, List<Employee>> employeeByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        for (String department : employeeByDepartment.keySet()) {
            System.out.println(department + " " + employeeByDepartment.get(department));
        }

        // partition by -> true/false
        Map<Boolean, List<Employee>> employeeByIsActive = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isActive));
        for (Boolean isActive : employeeByIsActive.keySet()) {
            System.out.println(isActive + " " + employeeByIsActive.get(isActive));
        }

        // Count employees per department
        Map<String, Long> countEmployeeByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(countEmployeeByDepartment);

        // Average salary per department
        Map<String, Double> avgSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryByDepartment);

        // Sort employees in each department by salary

        // First Attempt
       /* Map<String,List<Employee>> sortEmployeeByDepartment = new HashMap<>();
        for(String key: employeeByDepartment.keySet()){
            List<Employee> sortedEmployee = employeeByDepartment.get(key).stream()
                    .sorted(Comparator.comparing(Employee::getSalary)).toList();
            sortEmployeeByDepartment.put(key,sortedEmployee);
        }
        System.out.println(sortEmployeeByDepartment);*/

        //After taking help
        Map<String, Stream<Employee>> sortEmployeeByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment, Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::getSalary))
                                )
                        )
                );
        for (String department : sortEmployeeByDepartment.keySet()) {
            for (Employee empl : sortEmployeeByDepartment.get(department).toList()) {
                System.out.println(empl.toString() + " ");
            }
        }

        // Multi-level grouping
        //How do you perform **multi-level grouping** using streams?
        //- Example: Group employees by department → then by designation.
        Map<String, Map<String, List<Employee>>> groupByDepartmentAndThenDesignation = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getDesignation)));
        System.out.println(groupByDepartmentAndThenDesignation);

        // Group employees by department and find the **highest-paid employee** in each department.
        Map<String, Optional<Employee>> maxSalaryInEachDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .max(Comparator.comparingDouble(Employee::getSalary))
                )));
        System.out.println(maxSalaryInEachDepartment);

        // Group employees by department and return only the **employee names**.
        /*Map<String, Stream<String>> groupByDepartmentAndGetName = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .map(Employee::getName)
                )));
        for(String department : groupByDepartmentAndGetName.keySet()){
            System.out.print(department + " ");
            for(String name: groupByDepartmentAndGetName.get(department).toList()){
                System.out.println(name + " ");
            }
        }*/

        Map<String, List<String>> groupByDepartmentAndGetName = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        for (String department : groupByDepartmentAndGetName.keySet()) {
            System.out.print(department + " --> ");
            for (String name : groupByDepartmentAndGetName.get(department)) {
                System.out.print(name + " ");
            }
            System.out.println();
        }

        // Group employees by department and count employees with salary > 50,000.

        Map<String, Long> departmentWithSalaryGreaterThan = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.filtering(empl -> empl.getSalary() > 50000, Collectors.counting())
                ));
        System.out.println(departmentWithSalaryGreaterThan);

        // Group employees by department and sum salaries
        Map<String, Double> sumOfSalariesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)
                ));
        System.out.println(sumOfSalariesByDepartment);

        // Find the department with the highest total salary
        String departmentWithHighestTotalSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)
                )).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
        System.out.println(departmentWithHighestTotalSalary);

        // Find employees grouped by department, but only include departments having more than 5 employees

        Map<String, List<Employee>> departmentWithEmployeesGreaterThan = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment
                )).entrySet().stream()
                .filter(e -> e.getValue().size() > 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(departmentWithEmployeesGreaterThan);

        // Group employees by department and return a Map<String, Double> of average salaries

        Map<String, Double> departmentAverageSalaries = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println(departmentAverageSalaries);

        // Group employees by age bracket (20–30, 30–40, 40+)
        Map<String, List<Employee>> employeeWithAgeBracket = employees.stream()
                .collect(Collectors.groupingBy(employee -> {
                    if (employee.getAge() >= 20 && employee.getAge() <= 30)
                        return "20-30";
                    else if (employee.getAge() > 30 && employee.getAge() <= 40)
                        return "30-40";
                    else
                        return "40-above";
                }));
        System.out.println(employeeWithAgeBracket);

        // Group employees by department and get top two salaries in each department
        Map<String, List<Employee>> topTwoEmployeesInEachDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .limit(2)
                                        .collect(Collectors.toList())
                        )
                ));

        System.out.println(topTwoEmployeesInEachDepartment);

    }
}
