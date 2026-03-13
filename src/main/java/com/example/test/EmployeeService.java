package com.example.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.IntegerSyntax;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private com.example.test.EmployeeRepository employeeRepository;

    public void insertData(com.example.test.Employee employee) {
        if (employee != null)
            System.out.println("INto insert method");
        employeeRepository.save(employee);
        System.out.println("Data save sucessfully");
    }

    public com.example.test.Employee getDetailById(Long id) {
        com.example.test.Employee empDetails = employeeRepository.findById(id).get();
//                .orElseThrow(() -> new NoSuchElementException());

        return empDetails;
    }

    public List<com.example.test.Employee> findAll() {

        List<com.example.test.Employee> allDetail = employeeRepository.findAll();
        if (allDetail != null) {
            System.out.println("object is not null");
        }
        return allDetail;
    }
}
