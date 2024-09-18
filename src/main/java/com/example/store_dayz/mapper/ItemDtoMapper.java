package com.example.store_dayz.mapper;

import com.example.store_dayz.entity.ItemsEntity;
import org.mapstruct.Mapper;
import com.example.types.ItemDTO;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemDtoMapper extends GenericMapper<ItemDTO, ItemsEntity>{
  @Override
  @Mapping(target = "image", source = "itemsEntity.image")
  @Mapping(target = "amount", source = "itemsEntity.amount")
  @Mapping(target = "config", source = "itemsEntity.config")
  @Mapping(target = "name", source = "itemsEntity.name")
  @Mapping(target = "category", source = "itemsEntity.category")
  @Mapping(target = "price", source = "itemsEntity.price")
  @Mapping(target = "description", source = "itemsEntity.description")
  @Mapping(target = "availableServers", expression = "java(AvailableServersMapper.map(itemsEntity.getAvailableServers()))")
  ItemDTO toDto(ItemsEntity itemsEntity);
}
