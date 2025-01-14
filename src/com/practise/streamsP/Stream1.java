package com.practise.streamsP;

import java.util.*;

//import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee1{
    public int id;
    public String name;
    public int salary;
    
    public Employee1(int a, String b, int c)
    {
        this.id=a;
        this.name=b;
        this.salary=c;
    }
}
class Stream1 {
    public static void main(String[] args) {
        ArrayList<Employee1> al = new ArrayList<Employee1>();
        al.add(new Employee1(1, "Thejas", 30000));
        al.add(new Employee1(1, "Ranjith", 10000));
        al.add(new Employee1(1, "Shreyas", 40000));
        al.add(new Employee1(1, "Vishal", 20000));
        al.add(new Employee1(1, "Gautam", 20000));
        System.out.println("Hello, World!");
        
        List<Employee1> empList=al.stream()
                .sorted(Comparator.comparing((Employee1 i)->i.salary).thenComparing(( j)->j.name))
                .collect(Collectors.toList());
        
        
//        IntStream.iterate(0, i->i+2)
//        .limit(100)
//        .forEach(System.out::print);
//        
//        
//        
//        al.stream();
//		java.util.stream.Stream.iterate(1,i->i+1)
//		.limit(100)
//		.forEach(System.out::println);
        
        
        
        
        for(Employee1 i:empList)
        {
         System.out.println(i.name +"     "+i.salary);
        }
        
        System.out.println("---------------------------------------------------");
        
        List<String> a=al.stream()
        .filter(i -> i.salary>10000)
        .map(p->
        {
        	return p.name;
        })
        .collect(Collectors.toList());
        
        for(String i:a)
        {
         System.out.println(i);
        }
        
        System.out.println("---------------------------------------------------");
        
        List<Integer> empList1=al.stream()
                .map(emp -> emp.salary)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        
        for(int i:empList1)
        {
         System.out.println(i);
        }
        
        System.out.println("-----------------------------------------------------");
        
        Integer[] firstArray = new Integer[] {10, 20, 30, 40};
        Integer[] secondArray = new Integer[] {50, 60, 70, 80};
                                                                 
        Integer[] mergedArray = Stream.of(firstArray, secondArray)
                .flatMap(Arrays::stream)
                .toArray(Integer[]::new);
        
        int[] firstArray1 = new int[] {10, 20, 30, 40};
        int[] secondArray1 = new int[] {50, 60, 70, 80};
        
        int[] merged = Stream.of(firstArray1,secondArray1).flatMapToInt(Arrays::stream).toArray();
        
        
        
        System.out.println("---------------------------------------------------------");
        System.out.println();
        
        List<String>[] arrayOfLists = new List[]{
                Arrays.asList("one", "two"),
                Arrays.asList("three", "four"),
                Arrays.asList("five", "six")
            };

            List<String> flattenedList = Stream.of(arrayOfLists)
                                               .flatMap(List::stream)
                                               .collect(Collectors.toList());
            
            System.out.println("flattenedList   "+flattenedList);
            
            List<List<String>> listOfLists = Arrays.asList(
                    Arrays.asList("one", "two"),
                    Arrays.asList("three", "four"),
                    Arrays.asList("five", "six")
                );
            
            String abc = listOfLists.stream().flatMap(i ->i.stream()).reduce((c,f)->c+" "+f).get();
            System.out.println();
            System.out.println(" th concatenedtd string is  "+abc);
            
       
    }
}



