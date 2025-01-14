package com.practise.object;

import java.util.HashMap;
import java.util.HashSet;

 class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
    public boolean equals(Object obj) {
    	System.out.println("obj  "+obj.hashCode());
    	System.out.println("obj  "+this.hashCode());
        if (obj == this)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employee employee = (Employee) obj;
        return employee.getAge() == this.getAge() && employee.getName() == this.getName();
    }

    // commented    
     @Override
        public int hashCode() {
            int result=17;
            result=31*result+age;
            result=31*result+(name!=null ? name.hashCode():0);
            return result;
        }

     
}

 class ClientTest {
    public static void main(String[] args) {
    	Employee employee = new Employee("rajeev", 24);
    	Employee employee1 = new Employee("rajeev", 25);
    	Employee employee2 = new Employee("rajeev1", 24);

//        HashSet<Employee> employees = new HashSet<Employee>();
//        System.out.println("hashcode ::::"+employees.hashCode());
        
        HashMap<Employee, Employee> emp1 = new HashMap<Employee, Employee>();
        emp1.put(employee,employee);
        emp1.put(employee2,employee2);
        
      //  System.out.println(emp1.get(employee).age);
        
        emp1.forEach((k,v)-> System.out.println("k "+k.hashCode() +" "+v.name));
//        employees.add(employee);
//        employees.add(employee2);
//        employees.add(employee1);
       
//        System.out.println("Hash Set size: "+employees.size());
        
        employee2.name="rajeev";
//        System.out.println("After Hash Set size: "+employees.size());
//        System.out.println(employees.contains(employee2));
        System.out.println("employee.hashCode():  " + employee.hashCode()
        + "\nemployee2.hashCode():" + employee2.hashCode());
        
        
        
    }
}