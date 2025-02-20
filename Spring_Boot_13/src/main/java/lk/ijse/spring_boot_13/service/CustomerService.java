package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.entity.Customer;

import java.util.List;

public interface CustomerService {
    void save(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(int id);
    Customer findById(int customerId);
}
