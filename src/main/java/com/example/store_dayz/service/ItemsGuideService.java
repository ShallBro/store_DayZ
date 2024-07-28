package com.example.store_dayz.service;

import com.example.store_dayz.dto.ItemGuideDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemsGuideService {

  public List<ItemGuideDTO> allItemsGuide() {
    return List.of(
      new ItemGuideDTO("item-1", "Как работают переходы на Север-Юг/Юг-Север", "https://i.imgur.com/iW8twMt.png", "dQw4w9WgXcQ"),
      new ItemGuideDTO("item-2", "Как работают переходы на Север-Юг/Юг-Север", "https://i.imgur.com/iW8twMt.png", "dQw4w9WgXcQ"));
  }
}
