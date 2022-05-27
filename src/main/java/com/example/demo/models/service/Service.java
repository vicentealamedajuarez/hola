package com.example.demo.models.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service

public class Service implements IService {
    public String hola(){
        return "Hola Mundo";
    }
    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> res = new ArrayList<>();
        repository.findAll().forEach(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            res.add(employeeDTO);
        });
        return res;
    }

    public EmployeeDTO createOrSaveEmployee(EmployeeDTO newEmployee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        Employee employee = new Employee();
        employee.setId(newEmployee.getId());
        employee.setEmail(newEmployee.getEmail());
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());

        Employee employeeRes = repository.save(employee);
        if(employee!=null){
            employeeDTO.setId(employeeRes.getId());
            employeeDTO.setEmail(employeeRes.getEmail());
            employeeDTO.setFirstName(employeeRes.getFirstName());
            employeeDTO.setLastName(employeeRes.getLastName());
        }
        return employeeDTO;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = repository.findById(id).get();
        if(employee!=null){
            employeeDTO.setId(employee.getId());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
        }
        return employeeDTO;
    }

    public EmployeeDTO updateEmployee(EmployeeDTO newEmployee, Long id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

        return repository.findById(id).map(employee -> {
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setEmail(newEmployee.getEmail());
            Employee employeeRes = repository.save(employee);
            if(employeeRes!=null){
                employeeDTO.setId(employeeRes.getId());
                employeeDTO.setEmail(employeeRes.getEmail());
                employeeDTO.setFirstName(employeeRes.getFirstName());
                employeeDTO.setLastName(employeeRes.getLastName());
            }
            return employeeDTO;
        }).orElseGet(() -> {
            Employee employee = new Employee();
            employee.setId(id);
            Employee employeeRes = repository.save(employee);
            if(employeeRes!=null){
                employeeDTO.setId(employeeRes.getId());
                employeeDTO.setEmail(employeeRes.getEmail());
                employeeDTO.setFirstName(employeeRes.getFirstName());
                employeeDTO.setLastName(employeeRes.getLastName());
            }
            return employeeDTO;
        });
    }

    public void deleteEmployee( Long id) {
        repository.deleteById(id);
    }
}
