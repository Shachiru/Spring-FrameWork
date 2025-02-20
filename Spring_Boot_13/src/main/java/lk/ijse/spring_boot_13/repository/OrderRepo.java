package lk.ijse.spring_boot_13.repository;

import lk.ijse.spring_boot_13.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
