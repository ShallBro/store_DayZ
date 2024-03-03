package com.example.store_dayz.controller;

import com.example.store_dayz.model.Item;
import com.example.store_dayz.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restApi")
@AllArgsConstructor
public class StoreController{

  private StoreService storeService;

  @PostMapping("/addItem")
  public void addItem(@RequestBody Item item){
      storeService.addItemService(item);
  }

}