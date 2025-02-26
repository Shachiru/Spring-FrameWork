package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.service.OrderService;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAll")
    public ResponseUtil getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseUtil(200, "Success", orders);
    }
}