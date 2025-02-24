package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.service.OrderService;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin(origins = "*")
public class OrderPlaceController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "place")
    public ResponseUtil placeOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.placeOrder(orderDTO);
    }
}