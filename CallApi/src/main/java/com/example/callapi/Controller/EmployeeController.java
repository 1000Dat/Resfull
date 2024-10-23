package com.example.callapi.Controller;

import com.example.callapi.Entity.EmployeeEntity;

import com.example.callapi.Service.EmployeeService;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) {

        EmployeeEntity employeeEntity = employeeService.save(employee);
        return   new ResponseEntity<>(employeeEntity, HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employeeEntity =  employeeService.getAll();
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee, @PathVariable Integer id) {
        EmployeeEntity employeeEntity = employeeService.update(employee,id);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Optional<EmployeeEntity>> getEmployees(@PathVariable Integer id) {
        Optional<EmployeeEntity> employeeEntity =  employeeService.get(id);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
