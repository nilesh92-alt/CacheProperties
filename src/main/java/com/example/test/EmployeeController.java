package com.example.test;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final com.example.test.EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @GetMapping("/test")
    public String getName() {
        return "Welcome to spring boot project";
    }

    @PostMapping("/insert")
    public String insertData(@RequestBody Employee employee) {
        System.out.println("Into insert method");
        employeeService.insertData(employee);
        return "Success";
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<com.example.test.Employee> getEmployeeBy(@PathVariable("id") Long id) {

        Student student = new Student(1L, "Nilesh", "IT");
        StudentDTO studentDTO1 = new StudentDTO(2L, "Nikhil");
//        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);

        Student student1 = modelMapper.map(studentDTO1, Student.class);

//        System.out.println("FInal outPUt " + studentDTO);
        System.out.println("FInal outPUt " + student1);

        Employee detailById = employeeService.getDetailById(id);

        return ResponseEntity.ok(detailById);
    }


    @GetMapping("/findall")
    @CacheEvict(cacheNames = "employee", allEntries = true)
    public ResponseEntity getEmployeeAll() {

        List<Employee> findAllEmp = employeeService.findAll();

        return ResponseEntity.ok(findAllEmp);
    }
}
