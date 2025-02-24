package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.util.ResponseUtil;

public interface OrderService {
    ResponseUtil placeOrder(OrderDTO orderDTO);
}