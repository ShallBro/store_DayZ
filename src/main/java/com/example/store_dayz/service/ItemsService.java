package com.example.store_dayz.service;

import com.example.store_dayz.dao.ItemsDAOImpl;
import com.example.store_dayz.entity.AvailableServersEntity;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.mapper.GenericMapper;
import com.example.store_dayz.repository.ItemsRepository;
import com.example.types.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemsService {

  private final ItemsRepository itemsRepository;

  private final GenericMapper<ItemDTO, ItemsEntity> genericMapper;

  public void addItem(ItemDTO itemDTO) {
   itemsRepository.save(new ItemsEntity(itemDTO));
  }

  public void updateItem(ItemDTO itemDTO) {
//    itemsDAO.updateItem(itemDTO);
  }

  public void deleteItem(String name) {
    itemsRepository.deleteByName(name);
  }

  public List<ItemDTO> getAllItems() {
    List<ItemsEntity> itemsEntities = itemsRepository.findAll();
    List<ItemDTO> itemDTOList = new ArrayList<>();
    for (ItemsEntity itemsEntity : itemsEntities) {
      itemDTOList.add(genericMapper.toDto(itemsEntity));
    }
    return itemDTOList;
  }

}
