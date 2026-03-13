package com.example.test;

public class EmployeeNotFoundException  extends  RuntimeException{

    String message;

    EmployeeNotFoundException(String message){
        super(message);
    }
}
