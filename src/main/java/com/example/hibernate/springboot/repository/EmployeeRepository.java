package com.example.hibernate.springboot.repository;


import com.example.hibernate.springboot.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
