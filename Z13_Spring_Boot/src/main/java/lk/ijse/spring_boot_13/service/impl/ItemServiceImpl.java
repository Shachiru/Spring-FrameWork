package lk.ijse.spring_boot_13.service.impl;

import lk.ijse.spring_boot_13.dto.ItemDTO;
import lk.ijse.spring_boot_13.entity.Item;
import lk.ijse.spring_boot_13.repository.ItemRepo;
import lk.ijse.spring_boot_13.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getId())) {
            throw new RuntimeException("Item already exists");
        }
    /*
        Item item = new Item(
                itemDTO.getId(),
                itemDTO.getDescription(),
                itemDTO.getQuantity(),
                itemDTO.getUnitPrice()
        );
    */
        itemRepo.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public List<ItemDTO> getAllItems() {
       /*
       List<Item> items = itemRepo.findAll();
        return items.stream().map(item -> new ItemDTO(item.getId(), item.getDescription(), item.getQuantity(), item.getUnitPrice())).collect(Collectors.toList());
        */

        return modelMapper.map(itemRepo.findAll(),
                new TypeToken<List<ItemDTO>>() {}.getType());
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getId())){
        /*
            Item item = new Item(
                    itemDTO.getId(),
                    itemDTO.getDescription(),
                    itemDTO.getQuantity(),
                    itemDTO.getUnitPrice()
            );
        */
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
        }
        throw new RuntimeException("Item already exists");
    }

    @Override
    public void deleteItem(int id) {
        if (itemRepo.existsById(id)){
            itemRepo.deleteById(id);
        }
        throw new RuntimeException("Item already exists");
    }

    @Override
    public Item findById(int itemId) {
        Optional<Item> item = itemRepo.findById(itemId);
        return item.orElse(null);
    }

    @Override
    public ItemDTO getItemById(int id) {
        Optional<Item> item = itemRepo.findById(id);
        if (item.isPresent()) {
            return modelMapper.map(item.get(), ItemDTO.class);
        } else {
            throw new RuntimeException("Item not found");
        }
    }
}
