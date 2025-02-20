package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.service.CustomerService;
import lk.ijse.spring_boot_13.service.impl.CustomerServiceImpl;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "save")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerServiceImpl.save(customerDTO);
        return new ResponseUtil(201, "Customer is saved", null);
    }

    @GetMapping(path = "getAll")
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200, "Success", customerService.getAllCustomers());
    }

    @PutMapping(path = "update")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerServiceImpl.updateCustomer(customerDTO);
        return new ResponseUtil(200, "Customer updated successfully", null);
    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable int id) {
        customerServiceImpl.deleteCustomer(id);
        return new ResponseUtil(200, "Customer deleted successfully", null);
    }
}
