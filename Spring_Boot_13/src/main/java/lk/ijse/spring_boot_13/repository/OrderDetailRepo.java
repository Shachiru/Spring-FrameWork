package lk.ijse.spring_boot_13.repository;

import lk.ijse.spring_boot_13.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail,Integer> {
}
