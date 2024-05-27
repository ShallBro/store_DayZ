package com.example.store_dayz.service;

import com.example.store_dayz.dao.ItemsDAOImpl;
import com.example.store_dayz.entity.AvailableServersEntity;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

  private final ItemsDAOImpl itemsDAO;

  @Autowired
  public StoreService(ItemsDAOImpl itemsDAO) {
    this.itemsDAO = itemsDAO;
  }

  public void addItem(Item item) {
    itemsDAO.insertItem(item);
  }

  public void updateItem(Item item) {
    itemsDAO.updateItem(item);
  }

  public void deleteItem(int id) {
    itemsDAO.deleteItem(id);
  }

  public List<Item> getAllItems() {
    List<ItemsEntity> itemsEntities = itemsDAO.selectItems();
    List<Item> itemList = new ArrayList<>();
    for (ItemsEntity itemsEntity : itemsEntities) {
      Item item = new Item();
      List<AvailableServersEntity> availableServersEntities = itemsDAO.getAvailableServersForItem(itemsEntity.getId());
      List<String> serversName = availableServersEntities.stream()
        .map(AvailableServersEntity::getName)
        .collect(Collectors.toList());
      item.setAvailable_servers(serversName);
      item.setId(itemsEntity.getId());
      item.setAmount(itemsEntity.getAmount());
      item.setConfig(itemsEntity.getConfig());
      item.setName(itemsEntity.getName());
      item.setCategory(itemsEntity.getCategory());
      item.setPrice(itemsEntity.getPrice());
      item.setImage(itemsEntity.getImage());
      item.setDescription(itemsEntity.getDescription());
      itemList.add(item);
    }
    return itemList;
  }

}
