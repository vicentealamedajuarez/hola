package com.example.demo.models.service;

import com.example.demo.dto.EmployeeDTO;

import java.util.List;

public interface IService {
    String hola();

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO createOrSaveEmployee(EmployeeDTO newEmployee);
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(EmployeeDTO newEmployee, Long id);
    void deleteEmployee( Long id);

}
