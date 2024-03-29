package com.example.store_dayz.controller;

import com.example.store_dayz.model.Item;
import com.example.store_dayz.service.StoreService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
      storeService.addItemService(item);
  }

}