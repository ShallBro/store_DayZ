package com.example.store_dayz.mapper;

public interface GenericMapper<DTO, Entity> {
  DTO toDto(Entity entity);
}
