package com.mycompany.apexdemo.exception;

public class DuplicateCustomer extends RuntimeException{
    public DuplicateCustomer() {}

    public DuplicateCustomer(String emailId) {
        super("Customer already exist with emailId=" + emailId);
    }
}
