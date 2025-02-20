package lk.ijse.spring_boot_13.repository;

import lk.ijse.spring_boot_13.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
