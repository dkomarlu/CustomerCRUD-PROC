package com.mycompany.apexdemo.service;

import com.mycompany.apexdemo.dto.CustomerDTO;
import com.mycompany.apexdemo.entiry.Customer;
import com.mycompany.apexdemo.exception.CustomerNotFound;
import com.mycompany.apexdemo.exception.DuplicateCustomer;
import com.mycompany.apexdemo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(this::convert2DTO)
                .toList();
    }

    public CustomerDTO getACustomer (Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFound(id));

         return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO findCustomer(String emailId) {
        Customer customer = customerRepository.findByEmailId(emailId);
        if (customer == null) {
            throw new CustomerNotFound(emailId);
        }
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public String deleteCustomer (Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFound(id));
        customerRepository.deleteById(customer.getId());
        return "Customer deleted with ID=" + id;
    }

    public CustomerDTO addCustomer (CustomerDTO customerDTO) {
        Customer customer = customerRepository.findByEmailId(customerDTO.getEmailId());
        if (customer != null) {
            throw new DuplicateCustomer(customerDTO.getEmailId());
        }
        customer = modelMapper.map(customerDTO, Customer.class);
        Customer customerAdded = customerRepository.save(customer);
        return modelMapper.map(customerAdded, CustomerDTO.class);
    }

    private CustomerDTO convert2DTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }


}
