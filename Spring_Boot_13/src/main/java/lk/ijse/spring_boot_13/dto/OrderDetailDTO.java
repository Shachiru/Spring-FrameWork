package lk.ijse.spring_boot_13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO {
    private int id;
    private int orderId;
    private int itemId;
    private int quantity;
    private double totalPrice;
}
