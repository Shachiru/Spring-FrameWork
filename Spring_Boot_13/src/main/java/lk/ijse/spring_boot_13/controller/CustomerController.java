package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    // property injection
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping(path = "save")
    public boolean getCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean res = customerServiceImpl.save(customerDTO);
        return res;
    }
    @GetMapping("getAll")
    public List<CustomerDTO> getAllCustomers() {
        return customerServiceImpl.getAllCustomers();
    }

    @PutMapping("update")
    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerServiceImpl.updateCustomer(customerDTO);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteCustomer(@PathVariable int id) {
        return customerServiceImpl.deleteCustomer(id);
    }
}
