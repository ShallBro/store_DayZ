package com.example.store_dayz.entity;

import com.example.store_dayz.dto.ItemDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class ItemsEntity {

  @Id
  private long id;

  private String name;
  private String description;
  private Integer amount;
  private Integer price;
  private String config;
  private String category;
  private String image;
  @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
  private List<AvailableServersEntity> availableServers;

  public ItemsEntity(ItemDTO itemDTO) {
    id = itemDTO.getId();
    name = itemDTO.getName();
    description = itemDTO.getDescription();
    amount = itemDTO.getAmount();
    price = itemDTO.getPrice();
    config = itemDTO.getConfig();
    category = itemDTO.getCategory();
    image = itemDTO.getImage();
  }

  public void updateItemEntity(ItemDTO itemDTO) {
    name = itemDTO.getName();
    description = itemDTO.getDescription();
    amount = itemDTO.getAmount();
    price = itemDTO.getPrice();
    config = itemDTO.getConfig();
    category = itemDTO.getCategory();
    image = itemDTO.getImage();
  }

  public ItemsEntity() {

  }
}
