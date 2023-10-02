package com.DatabaseMvc1.Mvc1.Service;

import com.DatabaseMvc1.Mvc1.model.Employee;
import com.DatabaseMvc1.Mvc1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> displayEmployeeData(){
       return repository.findAll();
    }


    public void addEmployee(Employee e){
        repository.save(e);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
}
