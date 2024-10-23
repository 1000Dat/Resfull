package com.example.callapi.Service.Impl;

import com.example.callapi.Entity.EmployeeEntity;
import com.example.callapi.Repository.EmployeeRepository;
import com.example.callapi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employee;

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {

       return employee.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> getAll() {
        List<EmployeeEntity> employeeAll = employee.findAll();
        return employeeAll;
    }

    @Override
    public EmployeeEntity update(EmployeeEntity employeeEntity,Integer id) {

        EmployeeEntity entity = employee.findById(id).orElseThrow(()-> new RuntimeException("không tim thấy"));
        entity.setEmail(employeeEntity.getEmail());
        entity.setFirstName(employeeEntity.getFirstName());
        entity.setLastName(employeeEntity.getLastName());
        return employee.save(entity);

    }

    @Override
    public Optional<EmployeeEntity> get(Integer id) {
        return employee.findById(id);
    }

    @Override
    public void delete(Integer id) {
        EmployeeEntity entity = employee.findById(id).orElseThrow(() -> new RuntimeException("Không thấy"));
        employee.delete(entity);
    }

//    public EmployeeEntity update(EmployeeEntity employeeEntity,Integer id) {
//
//        Optional<EmployeeEntity> entity = employee.findById(id);
//       if(!entity.isPresent() ) {
//           throw new RuntimeException("Employee Not Found");
//       }
//        return employee.save(employeeEntity);
//
//    }


}
