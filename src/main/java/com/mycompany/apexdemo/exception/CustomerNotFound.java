package com.mycompany.apexdemo.exception;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound() {}

    public CustomerNotFound(Long id) {
        super("Customer is not found with id=" + id);
    }

    public CustomerNotFound(String emailId) {
        super("Customer is not found with emailId=" + emailId);
    }
}
