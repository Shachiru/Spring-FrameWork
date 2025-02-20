package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.CustomerDTO;
import lk.ijse.spring_boot_13.service.impl.CustomerServiceImpl;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseUtil getCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean res = customerServiceImpl.save(customerDTO);
        if (res) {
            return new ResponseUtil(201,"Customer is saved",null);
        }
        return new ResponseUtil(409,"Already exist",null);
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
