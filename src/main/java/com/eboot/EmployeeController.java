package com.eboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){

        Employee result = employeeRepository.save(employee);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> get()
    {
        return employeeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{employeeId}")
    public Employee get(@PathVariable String employeeId){
        return employeeRepository.findOne(employeeId);
    }


}
