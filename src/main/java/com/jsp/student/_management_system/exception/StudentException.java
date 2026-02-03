package com.jsp.student._management_system.exception;

public class StudentException extends RuntimeException{

    public StudentException(String message){
        super(message);

        System.out.println("hello");

    }
}
