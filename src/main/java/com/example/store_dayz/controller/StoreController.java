package com.example.store_dayz.controller;

import com.example.store_dayz.model.Item;
import com.example.store_dayz.service.StoreService;
import java.util.List;
import java.util.Map;
import lombok.NoArgsConstructor;
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
@RequestMapping("/restApi")
@NoArgsConstructor
public class StoreController{

  private StoreService storeService;

  @Autowired
  public StoreController(StoreService storeService) {
    this.storeService = storeService;
  }

  @PostMapping("/addItem")
  public void addItem(@RequestBody Item item){
      storeService.addItem(item);
  }

  @GetMapping("/allItems")
  public List<Map<String,Object>> allItems(){
    return storeService.getAllItems();
  }

  @PutMapping("/updateItem")
  public void updateItem(@RequestBody Item item){
    storeService.updateItem(item);
  }

  @DeleteMapping("/deleteItem")
  public void deleteItem(@RequestParam("id") int id) {
    storeService.deleteItem(id);
  }

}