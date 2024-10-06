package com.practise.streamsP;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Employee {
	    public static void main(String[] args) {
	        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
	        // to see how IntelliJ IDEA suggests fixing it.
	        List<Employee> empList = new ArrayList<>();
	        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
	        empList.add(new Employee(3, "efg", 21, 115, "M", "HR", "Chennai", 2014));
	        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
	        empList.add(new Employee(7, "iii", 29, 100, "F", "TS", "Noida", 2019));
	        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
	        

//	        1. Group the Employees by city.
	        Map<String, List<Employee>> a = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
	        for(Map.Entry<String,List<Employee>> mp : a.entrySet()){
	            System.out.println(mp.getKey()+" "+mp.getValue());
	        }

//	        2. Group the Employees by age.
	        Map<Integer,List<Employee>> b = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
	        System.out.println(b);

//	        3. Find the count of male and female employees present in the organization.
	        Map<String,Long> c = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
	        System.out.println(c);

//	        4. Print the names of all departments in the organization.
	        empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

//	        5. Print employee details whose age is greater than 28.
	        empList.stream().filter(emp->emp.getAge()>28).forEach(System.out::println);

//	        6. Find maximum age of employee.
	        System.out.println(empList.stream().max(Comparator.comparingDouble(Employee::getAge))); // this will give employee detaisl
	        System.out.println(empList.stream().mapToInt(emp->emp.getAge()).max().getAsInt());       // this will give only age

//	        7. Print Average age of Male and Female Employees.
	        Map<String,Double> g = empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge)));
	        System.out.println(g);

//	        8. Print the number of employees in each department.
	        Map<String, Long> h = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()));
	        System.out.println(h);

//	        9. Find oldest employee.
	        Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::getAge));

	        System.out.println(empList.stream().mapToInt(Employee::getAge).max().getAsInt());

//	        10. Find youngest female employee.
	        Optional<Employee> i= empList.stream().min(Comparator.comparing(Employee::getAge));
	        if(i.isPresent()){
	            System.out.println(i);
	        }

//	        11. Find employees whose age is greater than 30 and less than 30.
			Map<Boolean, List<Employee>> q = empList.stream()
					.collect(Collectors.partitioningBy(emp -> emp.getAge() > 30));
			for (Map.Entry<Boolean, List<Employee>> mp : q.entrySet()) {
				if (Boolean.TRUE.equals(mp.getKey())) {
					System.out.println("Employees with age > 30" + mp.getValue());
				} else {
					System.out.println("Employees with age <= 30" + mp.getValue());
				}

			}

//	        12. Find the department name which has the highest number of employees.
	        Map.Entry<String, Long> w = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
	                              .entrySet().stream().max(Map.Entry.comparingByValue()).get();
	        System.out.println(w);

//	        13. Find if there any employees from HR Department.
	         empList.stream().filter(emp->emp.getDeptName().equalsIgnoreCase("HR")).collect(Collectors.toList()).forEach(System.out::println);

//	        14. Find the department names that these employees work for, where the number of employees in the department is over 3.
	        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
	                .entrySet().stream().filter(emp -> emp.getValue() <2).forEach(System.out::println);

//	        15 . Find distinct department names that employees work for.
	        empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

//	        16. Find all employees who lives in ‘Noida’ city, sort them by their name and print the names of employees.
	        empList.stream().filter(emp->emp.getCity().equalsIgnoreCase("Noida")).sorted(Comparator.comparing(Employee::getName))
	                .forEach(System.out::println);

//	        17. No of employees in the organisation.
	        System.out.println(empList.stream().count());

//	        18. Find employee count in every department
	        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())));

//	        20. Sorting a Stream by age and name fields.
	        Comparator<Employee> c1 = Comparator.comparing(Employee::getName);
	        Comparator<Employee> c2 = Comparator.comparingInt(Employee::getAge);
	        empList.stream().sorted(c2.thenComparing(c1)).collect(Collectors.toList()).forEach(System.out::println);

//	        21. Highest experienced employees in the organization.
	        System.out.println(empList.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get());

//	        22. Print average and total salary of the organization.
	        System.out.println(empList.stream().collect(Collectors.averagingLong(Employee::getSalary)));

	        LongSummaryStatistics s = empList.stream().collect(Collectors.summarizingLong(Employee::getSalary));
	        System.out.println(s.getAverage()+"\n"+s.getSum());

//	        23. Print Average salary of each department.
	        Map<String,Double> mp = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.averagingDouble(Employee::getSalary)));
	        System.out.println(mp);

//	        27. Find highest paid salary in the organisation based on gender.
	        Map<String, Optional<Employee>> as = empList.stream().collect(Collectors.groupingBy(Employee::getGender,
	        		Collectors.maxBy((t1,t2)->(int) (t1.getSalary()-t2.getSalary()))));
	        System.out.println(as);

//	        31. Highest salary based on department.
	        Map<String, Optional<Employee>> dd = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
	                Collectors.maxBy((a2, b2) -> (int) (a2.getSalary() - b2.getSalary()))));
	        for(Map.Entry<String, Optional<Employee>> mp1 : dd.entrySet()){
	            System.out.println(mp1.getKey()+" "+mp1.getValue());
	        }

//	        32. Print list of employee’s second highest record based on department
//	        This provides only salary
	        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
	                list -> list.stream().map(emp->emp.getSalary()).sorted(Comparator.reverseOrder()).skip(1).findFirst()))));

//	        This provides full object
	        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
	                list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst()))));

	        long startTime = System.nanoTime();
	        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
	        LocalDateTime tim= LocalDateTime.now();
	        listOfNumbers.parallelStream().forEach(number ->
	                System.out.println(number + " " + Thread.currentThread().getName())
	        );

	        long endTime   = System.nanoTime();
	        long totalTime = endTime - startTime;
	        System.out.println(totalTime);
	        
	        
//	        3. How to find duplicate elements in a given integers list in java using Stream functions?
	        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
	          Set<Integer> set = new HashSet();
	          myList.stream()
	                .filter(n -> !set.add(n))
	                .forEach(System.out::println);
	          
			  String input = "Java artles are Awesome";
			  Character result = input.chars() // Stream of String
//			      .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))    -->this is to check upper and lower
			      .mapToObj(s1->(char)s1) // First convert to Character object and then to lowercase
			      .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
			          .entrySet()
			          .stream()
			          .filter(entry -> entry.getValue() == 1L)
			          .map(entry -> entry.getKey())
			          .findFirst()
			          .get();
			  System.out.println(result);


//			  18. How to count each element/word from the String ArrayList in Java8?

	        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
	        Map<String,Long> namesCount = names
	                                .stream()
	                                .collect(
	                                 Collectors.groupingBy(
	                                   Function.identity()
	                                 , Collectors.counting()
	                                 ));
	        System.out.println(namesCount);
	
	//		Output:
	//		{CC=1, BB=1, AA=2}
        
	    }
}
