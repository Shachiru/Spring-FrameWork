package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
public class FormDataController {
    /*@PostMapping
    public String test1(@RequestParam(value = "id") String id,
                        @RequestParam(value = "name") String name) {
        return id + " : " + name;
    }*/

    @PostMapping
    public String test1(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO.getFirstName());
        return customerDTO.toString();
    }
}
