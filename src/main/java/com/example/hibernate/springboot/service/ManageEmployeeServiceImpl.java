package com.example.hibernate.springboot.service;


import com.example.hibernate.springboot.dao.EmployeeDAO;
import com.example.hibernate.springboot.entities.Employee;
import com.example.hibernate.springboot.entities.Tool;
import com.example.hibernate.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ManageEmployeeServiceImpl implements ManageEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void manageEmployees(){

        Set<Tool>tools = new HashSet<>();
        tools.add(new Tool("hummer", "red"));
        tools.add(new Tool("screwdriver", "red"));
        Integer empID1 = addEmployee("Zara", "Ali", 1000, tools).getId();

        tools = new HashSet<>();
        tools.add(new Tool("hummer", "green"));
        tools.add(new Tool("screwdriver", "green"));

        Integer empID2 = addEmployee("Daisy", "Das", 5000, tools).getId();

        tools = new HashSet<>();
        tools.add(new Tool("hummer", "yellow"));
        tools.add(new Tool("screwdriver", "yellow"));
        Integer empID3 = addEmployee("John", "Paul", 10000, tools).getId();

      /* List down all the employees */
        listEmployees();

      /* Update employee's records */
        updateEmployeeSalary(empID1, 5000);

        tools = new HashSet<>();
        tools.add(new Tool("hummer", "brown"));
        tools.add(new Tool("screwdriver", "brown"));
        updateEmployeeTools(empID1, tools);


      /* Delete an employee from the database */
        deleteEmployee(empID2);

      /* List down new list of the employees */
        listEmployees();

    }


    /* Method to CREATE an employee in the database */
    public Employee addEmployee(String fname, String lname, int salary, Set<Tool> tools){
        Employee employee = new Employee(fname, lname, salary);
        tools.forEach(r -> r.setEmployee(employee));
        employee.setTools(tools);
        return employeeRepository.save(employee);
    }

    /* Method to  READ all the employees */
    public void listEmployees( ){
        List<Employee> employees = employeeRepository.findAll();

        for (Object emp: employees){
            Employee employee = (Employee) emp;
            System.out.print("First Name: " + employee.getFirstName());
            System.out.print("  Last Name: " + employee.getLastName());
            System.out.println("  Salary: " + employee.getSalary());
            System.out.println("  Tools: " + employee.getTools());
        }

    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployeeSalary(Integer employeeId, int salary ){
        Employee employee = employeeRepository.findOne(employeeId);
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    public void updateEmployeeTools(Integer employeeId, Set<Tool> tools){
        Employee employee = employeeRepository.findOne(employeeId);
        tools.forEach(r -> r.setEmployee(employee));
        employee.getTools().clear();
        employee.getTools().addAll(tools);
        employeeRepository.save(employee);
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer employeeId){
        employeeRepository.delete(employeeId);
    }
}
