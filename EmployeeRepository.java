package com.DatabaseMvc1.Mvc1.repository;

import com.DatabaseMvc1.Mvc1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}
