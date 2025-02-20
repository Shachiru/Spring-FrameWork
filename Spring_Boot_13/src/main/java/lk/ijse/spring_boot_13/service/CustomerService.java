package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.entity.Customer;

import java.util.List;

public interface CustomerService {
    boolean save(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    boolean updateCustomer(CustomerDTO customerDTO);
    boolean deleteCustomer(int id);
    Customer findById(int customerId);
}
