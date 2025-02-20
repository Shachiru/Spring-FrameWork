package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.entity.Item;

import java.util.List;

public interface ItemService {
    boolean saveItem(ItemDTO itemDTO);
    List<ItemDTO> getAllItems();
    boolean updateItem(ItemDTO itemDTO);
    boolean deleteItem(int id);
    Item findById(int itemId);
}
