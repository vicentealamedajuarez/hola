package com.example.demo.controllers;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.models.service.IService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmployeeRESTController
{
    public final static Logger LOGGER = LoggerFactory.getLogger(EmployeeRESTController.class);
    @Autowired
    IService iService;

    @GetMapping(value = "/mundo")
    public String hola() {
        return new Date().toString()+" "+iService.hola();
    }

    @GetMapping(value = "/employees")
    public List<EmployeeDTO> getAllEmployees() {
        LOGGER.debug("Holas");
        return iService.getAllEmployees();
    }

    @PostMapping("/employees")
    EmployeeDTO createOrSaveEmployee(@RequestBody EmployeeDTO newEmployee) {
        return iService.createOrSaveEmployee(newEmployee);
    }

    @GetMapping("/employees/{id}")
    EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return iService.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    EmployeeDTO updateEmployee(@RequestBody EmployeeDTO newEmployee, @PathVariable Long id) {
        return iService.updateEmployee(newEmployee,id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        iService.deleteEmployee(id);
    }
}
