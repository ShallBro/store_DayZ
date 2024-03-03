package com.example.store_dayz.service;

import com.example.store_dayz.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

  private static final Logger LOGGER = LoggerFactory.getLogger(StoreService.class);

  public void addItemService(Item item){
      LOGGER.info(String.valueOf(item));
  }
}
