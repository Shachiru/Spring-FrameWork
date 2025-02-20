package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.service.impl.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO) {
        String response = placeOrderService.placeOrder(orderDTO);
        return ResponseEntity.ok(response);
    }
}
