package com.example.HealthcareManagement.exception;

import javax.naming.AuthenticationException;

public class RoleException extends AuthenticationException {
    public  RoleException(String message){
        super(message);
    }
}
