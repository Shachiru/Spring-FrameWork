package lk.ijse.spring_boot_13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private int id;
    private String description;
    private int quantity;
    private double unitPrice;
}
