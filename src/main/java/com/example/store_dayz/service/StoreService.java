package com.example.store_dayz.service;

import com.example.store_dayz.dao.impl.ItemsDAOImpl;
import com.example.store_dayz.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

  private final ItemsDAOImpl itemsDAO;

  @Autowired
  public StoreService(ItemsDAOImpl itemsDAO) {
    this.itemsDAO = itemsDAO;
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(StoreService.class);

  public void addItemService(Item item){
      LOGGER.info("Object item: {}", item);
      itemsDAO.insertItem(item);
  }
}
