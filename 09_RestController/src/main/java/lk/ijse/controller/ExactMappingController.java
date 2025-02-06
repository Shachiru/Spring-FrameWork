package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exact")
public class ExactMappingController {
    @GetMapping(path = "test1")
    public String extractMapping() {
        return "Get Mapping Invoked!";
    }

    @GetMapping(path = "test2")
    public String extractMapping2() {
        return "Get Mapping Invoked!";
    }
}
