package com.practise.streamsP;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8EmployeesTrial {

	public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 21, 115, "M", "hR", "Chennai", 2014));
        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(7, "iii", 29, 100, "F", "TS", "Noida", 2019));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        

//        1. Group the Employees by city.
//        empList.stream().collect(Collectors.groupingBy(Employee::getCity)).entrySet().forEach(System.out::println);

//        2. Group the Employees by age.
//        empList.stream().collect(Collectors.groupingBy(Employee::getAge)).entrySet().forEach(System.out::println);

//        3. Find the count of male and female employees present in the organization.
//        empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())).entrySet().forEach(System.out::println);

//        4. Print the names of all departments in the organization.
//        empList.stream().map(emp->emp.getDeptName().toUpperCase()).distinct().forEach(System.out::println);

//        5. Print employee details whose age is greater than 28.
//        empList.stream().filter(emp->emp.getAge()>28).forEach(System.out::println);
        
//        6. Find maximum age of employee.
//        System.out.println(empList.stream().max(Comparator.comparingDouble(Employee::getAge)));
//        System.out.println(empList.stream().mapToInt(Employee::getAge).max().getAsInt());


//        7. Print Average age of Male and Female Employees.
//        empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge))).entrySet()
//        .forEach(System.out::println);
       
//        8. Print the number of employees in each department.
//        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())).entrySet()
//        .forEach(System.out::println);

//        9. Find oldest employee.
//        System.out.println(empList.stream().max(Comparator.comparing(Employee::getAge)));

//        10. Find youngest female employee.
//        System.out.println(empList.stream().filter(emp->emp.getGender().equalsIgnoreCase("F")).min(Comparator.comparing(Employee::getAge)));
       
//        11. Find employees whose age is greater than 30 and less than 30.
//      Map<Boolean, List<Employee>> empl = empList.stream().collect(Collectors.partitioningBy(e->e.getAge()>28));
//      for(Map.Entry<Boolean, List<Employee>> abc:empl.entrySet()) {
//    	  if(Boolean.TRUE.equals(abc.getKey())) {
//    		  System.out.println("Employee with age > 28 : "+abc.getValue());
//    	  }
//    	  else {
//    		  System.out.println("Employee with age < 28 : "+abc.getValue());
//
//    	  }
//      }
       
//        12. Find the department name which has the highest number of employees.
//        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())).entrySet()
//        	      .stream().max(Map.Entry.comparingByValue()).get());
        
       
//        13. Find if there any employees from HR Department.

//        14. Find the department names that these employees work for, where the number of employees in the department is over 3.
        
//        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())).entrySet()
//      	      .stream().filter(emp->emp.getValue()<2).forEach(System.out::println);
//        15 . Find distinct department names that employees work for.
//        empList.stream().map(em->em.getDeptName().toUpperCase()).distinct().forEach(System.out::println);
       
//        16. Find all employees who lives in ‘Noida’ city, sort them by their name and print the names of employees.
//        empList.stream().filter(emp->emp.getCity().equalsIgnoreCase("Noida")).sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
        
//        17. No of employees in the organisation.
//        System.out.println(empList.stream().count());
       
//        18. Find employee count in every department
//        empList.stream().collect(Collectors.groupingBy(emp->emp.getDeptName().toUpperCase(),Collectors.counting())).entrySet()
//      .stream().forEach(System.out::println);
        
//        19. Find the department which has the highest number of employees.
       
//        20. Sorting a Stream by age and name fields.
//        Comparator<Employee> c1 = Comparator.comparing(Employee::getName);
//        Comparator<Employee> c2 = Comparator.comparingInt(Employee::getAge);      
//        empList.stream().sorted(c1.thenComparing(c2)).forEach(System.out::println);
        
//        21. Highest experienced employees in the organization.
//        System.out.println(empList.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get());
        
//        22. Print average and total salary of the organization.
//          LongSummaryStatistics er = empList.stream().collect(Collectors.summarizingLong(Employee::getSalary));
//          System.out.println(er.getAverage()+ " "+er.getSum());
        
       
//        23. Print Average salary of each department.
        
//        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.averagingLong(Employee::getSalary))).entrySet()
//      .stream().forEach(System.out::println);
       
//        27. Find highest paid salary in the organisation based on gender.
        
        empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.maxBy((a,b)->(int) (a.getSalary()-b.getSalary())))).entrySet()
      .stream().forEach(System.out::println);
       
//        31. Highest salary based on department.
       

//        32. Print list of employee’s second highest record based on department
//        This provides only salary
        
//        This provides full object
      
	}

}
