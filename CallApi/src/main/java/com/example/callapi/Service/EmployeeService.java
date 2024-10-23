package com.example.callapi.Service;

import com.example.callapi.Entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {


    EmployeeEntity save(EmployeeEntity employeeEntity);

    List<EmployeeEntity> getAll();

    EmployeeEntity update(EmployeeEntity employeeEntity, Integer id);

    Optional<EmployeeEntity> get(Integer id);

    void delete(Integer id);
}
