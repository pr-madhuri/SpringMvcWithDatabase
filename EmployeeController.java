package com.DatabaseMvc1.Mvc1.Controller;

import com.DatabaseMvc1.Mvc1.Service.EmployeeService;
import com.DatabaseMvc1.Mvc1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @GetMapping("/")
    public String getMessage(){
        return "index";
    }

    @GetMapping("/employeeData")
    public String displayData(Model model){
      List<Employee> data=service.displayEmployeeData();
      model.addAttribute("employeeData",data);
      return "displayEmployee";
    }

    @GetMapping("/addEmployee")
    public String addTempEmployee(Model model){
        model.addAttribute("tempEmployee",new Employee());
        return "addEmployeeData";
    }

     @PostMapping("/addEmpInfo")
    public String addEmp(Employee e){
        service.addEmployee(e);
        return "redirect:/employeeData";
     }
      @GetMapping("/updateCurrentEmployee/{id}")
     public String updateTemp(@PathVariable int id,Model model){
        Employee emp=null;
       List<Employee> e= service.displayEmployeeData();
        for(Employee temp:e){
            if(temp.getEmpId()==id){
                emp=temp;
                break;
            }
        }
        model.addAttribute("tempEmp",emp);
        return "update";
    }
    @GetMapping("/updateEmp")
    public String updateEmp(Employee e){
        service.addEmployee(e);
        return "redirect:/employeeData";
    }

    @GetMapping("/deleteCurrentEmployee/{id}")
    public String deleteEmp(@PathVariable("id") int id){
      service.deleteById(id);
      return "redirect:/employeeData";
    }
}
