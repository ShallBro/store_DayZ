package com.example.store_dayz.controller;

import com.example.store_dayz.dto.ItemGuideDTO;
import com.example.store_dayz.service.ItemsGuideService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restApi/itemsGuide")

public class ItemsGuideController {

  private final ItemsGuideService itemsGuideService;

  @Autowired
  public ItemsGuideController(ItemsGuideService itemsGuideService) {
    this.itemsGuideService = itemsGuideService;
  }

  @GetMapping("/allItemsGuide")
  public List<ItemGuideDTO> allItemsGuide() {
    return itemsGuideService.allItemsGuide();
  }
}
