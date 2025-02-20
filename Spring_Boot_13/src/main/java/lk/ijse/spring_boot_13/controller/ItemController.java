package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @PostMapping(path = "save")
    public boolean saveItem(@RequestBody ItemDTO itemDTO) {
        boolean res = itemServiceImpl.saveItem(itemDTO);
        return res;
    }

    @GetMapping("getAll")
    public List<ItemDTO> getAllItems() {
        return itemServiceImpl.getAllItems();
    }

    @PutMapping("update")
    public boolean updateItem(@RequestBody ItemDTO itemDTO) {
        return itemServiceImpl.updateItem(itemDTO);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteItem(@PathVariable int id) {
        return itemServiceImpl.deleteItem(id);
    }

}
