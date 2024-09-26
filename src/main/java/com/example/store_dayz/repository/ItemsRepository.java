package com.example.store_dayz.repository;

import com.example.store_dayz.entity.ItemsEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, UUID> {
  void deleteByName(String name);
}
