package com.mycompany.apexdemo.controller;

import com.mycompany.apexdemo.dto.CustomerDTO;
import com.mycompany.apexdemo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCutomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getACustomer (@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getACustomer(id);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<CustomerDTO> findCustomerByEmailId(@RequestParam(name = "emailId") String emailId ) {
        CustomerDTO customerDTO = customerService.findCustomer(emailId);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer (@Valid  @RequestBody  CustomerDTO customerDTO) {
        customerDTO = customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer (@PathVariable Long id) {
        String resp = customerService.deleteCustomer(id);
        return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
    }

}
