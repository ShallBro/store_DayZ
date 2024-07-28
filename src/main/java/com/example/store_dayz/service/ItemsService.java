package com.example.store_dayz.service;

import com.example.store_dayz.dao.ItemsDAOImpl;
import com.example.store_dayz.entity.AvailableServersEntity;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.dto.ItemDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

  private final ItemsDAOImpl itemsDAO;

  @Autowired
  public ItemsService(ItemsDAOImpl itemsDAO) {
    this.itemsDAO = itemsDAO;
  }

  public void addItem(ItemDTO itemDTO) {
    itemsDAO.insertItem(itemDTO);
  }

  public void updateItem(ItemDTO itemDTO) {
    itemsDAO.updateItem(itemDTO);
  }

  public void deleteItem(int id) {
    itemsDAO.deleteItem(id);
  }

  public List<ItemDTO> getAllItems() {
    List<ItemsEntity> itemsEntities = itemsDAO.selectItems();
    List<ItemDTO> itemDTOList = new ArrayList<>();
    for (ItemsEntity itemsEntity : itemsEntities) {
      ItemDTO itemDTO = new ItemDTO();
      List<AvailableServersEntity> availableServersEntities = itemsDAO.getAvailableServersForItem(itemsEntity.getId());
      List<String> serversName = availableServersEntities.stream()
        .map(AvailableServersEntity::getName)
        .collect(Collectors.toList());
      // TODO: Переписать это на паттерн билдер
      itemDTO.setAvailable_servers(serversName);
      itemDTO.setId(itemsEntity.getId());
      itemDTO.setAmount(itemsEntity.getAmount());
      itemDTO.setConfig(itemsEntity.getConfig());
      itemDTO.setName(itemsEntity.getName());
      itemDTO.setCategory(itemsEntity.getCategory());
      itemDTO.setPrice(itemsEntity.getPrice());
      itemDTO.setImage(itemsEntity.getImage());
      itemDTO.setDescription(itemsEntity.getDescription());
      itemDTOList.add(itemDTO);
    }
    return itemDTOList;
  }

}
