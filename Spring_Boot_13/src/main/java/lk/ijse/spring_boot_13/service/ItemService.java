package lk.ijse.spring_boot_13.service;

import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.entity.Item;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    List<ItemDTO> getAllItems();
    void updateItem(ItemDTO itemDTO);
    void deleteItem(int id);
    Item findById(int itemId);

    ItemDTO getItemById(int id);
}
