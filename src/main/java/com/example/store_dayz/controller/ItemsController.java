package com.example.store_dayz.controller;

import com.example.store_dayz.dto.ItemDTO;
import com.example.store_dayz.service.ItemsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restApi/items")
public class ItemsController {

  private final ItemsService itemsService;

  @Autowired
  public ItemsController(ItemsService itemsService) {
    this.itemsService = itemsService;
  }

  @PostMapping("/addItem")
  public void addItem(@RequestBody ItemDTO itemDTO) {
      itemsService.addItem(itemDTO);
  }

  @GetMapping("/allItems")
  public List<ItemDTO> allItems(){
    return itemsService.getAllItems();
  }

  @PutMapping("/updateItem")
  public void updateItem(@RequestBody ItemDTO itemDTO) {
    itemsService.updateItem(itemDTO);
  }

  @DeleteMapping("/deleteItem")
  public void deleteItem(@RequestParam("id") int id) {
    itemsService.deleteItem(id);
  }

}