package lk.ijse.z17_spring_boot_loggins.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {
    //Trace, Debug, info, warnings, error
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/log-demo")
    public String logDemo() {
        log.trace("trace message");
        log.debug("debug message");
        log.info("info message");
        log.warn("warn message");
        log.error("error message");
        return "Hello World";
    }
}
