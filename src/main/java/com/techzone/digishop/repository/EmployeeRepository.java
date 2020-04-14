package com.techzone.digishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techzone.digishop.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
