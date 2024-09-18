package com.example.store_dayz.mapper;

import com.example.store_dayz.entity.AvailableServersEntity;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableServersMapper {

  public static List<String> map(List<AvailableServersEntity> entities) {
    return entities.stream()
      .map(AvailableServersEntity::getName)
      .collect(Collectors.toList());
  }
}
