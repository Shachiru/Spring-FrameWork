package lk.ijse.spring_boot_13.controller;

import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.service.ItemService;
import lk.ijse.spring_boot_13.service.impl.ItemServiceImpl;
import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemServiceImpl;
    @Autowired
    private ItemService itemService;

    @PostMapping(path = "save")
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO) {
        itemServiceImpl.saveItem(itemDTO);
        return new ResponseUtil(201, "Item is saved", null);
    }

    @GetMapping("getAll")
    public ResponseUtil getAllItems() {
        return new ResponseUtil(200, "success", itemService.getAllItems());
    }

    @GetMapping("{id}")
    public ResponseUtil getItemById(@PathVariable int id) {
        ItemDTO itemDTO = itemService.getItemById(id);
        return new ResponseUtil(200, "Success", itemDTO);
    }

    @PutMapping("update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        itemServiceImpl.updateItem(itemDTO);
        return new ResponseUtil(200, "Item updated successfully", null);
    }

    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
        return new ResponseUtil(200, "Item deleted successfully", null);
    }

}
