package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.util.ResponseUtil;

import java.util.List;

public interface OrderService {
    ResponseUtil placeOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
}