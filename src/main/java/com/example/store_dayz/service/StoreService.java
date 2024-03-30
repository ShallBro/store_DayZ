package com.example.store_dayz.service;

import com.example.store_dayz.dao.impl.ItemsDAOImpl;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.model.Item;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  public List<Map<String, Object>> allItemsService() {
      List<String> listKeyMap = List.of("name", "description", "category", "available_servers", "price");
      List<Map<String,Object>> items = new ArrayList<>();
      List<ItemsEntity> itemsEntities = itemsDAO.selectItems();
      // TODO Подумать как всё-таки переделать через массив Field доставать значение полей
      for (ItemsEntity itemsEntity : itemsEntities) {
        itemsEntity.setAvailable_servers(itemsDAO.getAvailableServersForItem(itemsEntity.getId()));
        Map<String,Object> itemsMap = listKeyMap.stream()
          .collect(Collectors.toMap(keyStr -> keyStr, keyStr -> {
            try {
              Method getter = itemsEntity.getClass().getMethod("get" + keyStr.substring(0,1).toUpperCase() + keyStr.substring(1));
              return getter.invoke(itemsEntity);
            } catch (Exception e) {
              throw new RuntimeException(e);
            }
          }));
        items.add(itemsMap);
      }
      return items;
  }
}
