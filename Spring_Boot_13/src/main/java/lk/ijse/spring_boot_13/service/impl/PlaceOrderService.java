package lk.ijse.spring_boot_13.service.impl;

import lk.ijse.spring_boot_13.dto.OrderDTO;
import lk.ijse.spring_boot_13.entity.Customer;
import lk.ijse.spring_boot_13.entity.Item;
import lk.ijse.spring_boot_13.entity.Order;
import lk.ijse.spring_boot_13.entity.OrderDetail;
import lk.ijse.spring_boot_13.repository.OrderDetailRepo;
import lk.ijse.spring_boot_13.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceOrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private ItemServiceImpl itemServiceImpl;

    public String placeOrder(OrderDTO orderDTO) {
        // Find customer by ID
        Customer customer = customerServiceImpl.findById(orderDTO.getCustomerId());
        if (customer == null) {
            return "Customer not found!";
        }

        // Create Order Entity
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDate.now());

        // Convert OrderDetailsDTO to OrderDetail Entities
        List<OrderDetail> orderDetails = orderDTO.getOrderDetails().stream().map(orderDetailDTO -> {
            // Find the Item by ID
            Item item = itemServiceImpl.findById(orderDetailDTO.getItemId());
            if (item == null) {
                return null;
            }

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setItem(item);
            orderDetail.setQuantity(orderDetailDTO.getQuantity());
            orderDetail.setTotalPrice(orderDetailDTO.getTotalPrice());
            orderDetail.setOrder(order);  // Setting the parent order
            return orderDetail;
        }).filter(orderDetail -> orderDetail != null).collect(Collectors.toList());

        order.setOrderDetails(orderDetails);

        orderRepo.save(order);
        orderDetailRepo.saveAll(orderDetails);
        return "Order placed successfully!";
    }
}
