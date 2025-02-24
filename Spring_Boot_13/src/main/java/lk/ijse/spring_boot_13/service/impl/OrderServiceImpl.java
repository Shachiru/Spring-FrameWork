package lk.ijse.spring_boot_13.service.impl;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.dto.OrderDetailDTO;
import lk.ijse.spring_boot_13.entity.*;
import lk.ijse.spring_boot_13.repository.CustomerRepo;
import lk.ijse.spring_boot_13.repository.ItemRepo;
import lk.ijse.spring_boot_13.repository.OrderDetailRepo;
import lk.ijse.spring_boot_13.repository.OrderRepo;
import lk.ijse.spring_boot_13.service.OrderService;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepository;

    @Autowired
    private OrderDetailRepo orderDetailRepository;

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private ItemRepo itemRepository;

    @Override
    public ResponseUtil placeOrder(OrderDTO orderDTO) {
        // Find the customer
        Customer customer = customerRepository.findById(orderDTO.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));

        // Create the order
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());

        // Save the order
        Order savedOrder = orderRepository.save(order);

        // Create order details
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDTO detailDTO : orderDTO.getOrderDetails()) {
            Item item = itemRepository.findById(detailDTO.getItemId()).orElseThrow(() -> new RuntimeException("Item not found"));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(savedOrder);
            orderDetail.setItem(item);
            orderDetail.setQuantity(detailDTO.getQuantity());
            orderDetail.setTotalPrice(item.getUnitPrice() * detailDTO.getQuantity());

            orderDetails.add(orderDetail);
        }

        // Save order details
        orderDetailRepository.saveAll(orderDetails);

        return new ResponseUtil(201, "Order placed successfully", null);
    }
}