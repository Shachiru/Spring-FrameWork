package lk.ijse.controller;

import jdk.jfr.ContentType;
import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping("json")
public class JSONController {
    @PostMapping
    public String test1(@RequestBody CustomerDTO customerDTO) {
        return customerDTO.getFirstName();
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomerDTO test2(){
        return new CustomerDTO("shachiru","Rashmika", 15);
    }

    @GetMapping(path = "data", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ArrayList<CustomerDTO> test3(){
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        customerDTOS.add(new CustomerDTO("shachiru","Rashmika", 15));
        customerDTOS.add(new CustomerDTO("Danuka","Shehan", 14));
        customerDTOS.add(new CustomerDTO("Sunil","Hewage", 20));
        return customerDTOS;
    }
}
