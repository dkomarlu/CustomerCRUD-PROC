package com.mycompany.apexdemo.repository;

import com.mycompany.apexdemo.entiry.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByEmailId(String emailId);
}
