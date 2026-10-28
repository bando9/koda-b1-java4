package com.java1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.function.Supplier;

public class App 
{
    public static void main( String[] args )
    {

        Employee andi = new Employee("KR001", "Andi", 750_000);
        Employee budi = new Employee("KR002", "Budi", 500_000);
        Employee citra = new Employee("KR003", "Citra", 300_000);
        
        List<Employee> employees = new ArrayList<>();

        employees.add(andi);
        employees.add(budi);
        employees.add(citra);

        System.out.println("\nACTIVE QUERY\n");

        List<Employee> bigSalarEmployees = employees.stream().filter(account->account.getSalary() >= 500_000).toList();

        bigSalarEmployees.forEach(employee -> System.out.println(employee.getName()+" - Rp."+ employee.getSalary()));

        List<Employee> sortedEmployees = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).toList();

        System.out.println();

        System.out.println("\nSORTED BIG SALARY");

        sortedEmployees.forEach(employee->System.out.printf("%s - %d%n", employee.getName(), employee.getSalary()));

        System.out.println();
        System.out.println("\nEmployees name:");

        List<String> getNameEmployee = employees.stream().map(Employee::getName).toList();
        System.out.println(getNameEmployee);

        try {
            Employee employee = findEmployee(employees, "KR002").orElseThrow(() -> new NoSuchElementException("Tidak ditemukan"));

            System.out.println("Menemukan: "+employee.getName());
        } catch (NoSuchElementException e) {
            System.out.println("Error: "+ e.getMessage());
        }


        
        
    }
    
    static Optional<Employee> findEmployee(List<Employee> employees, String id) {
        return employees.stream().filter(employee -> employee.getEmployeeID().equals(id)).findFirst();
    }
}
