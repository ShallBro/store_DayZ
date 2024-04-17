package com.example.store_dayz.entity;

import com.example.store_dayz.model.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

  @OneToMany(mappedBy = "item")
  private List<AvailableServersEntity> availableServers;

  public ItemsEntity(Item item) {
    id = item.getId();
    name = item.getName();
    description = item.getDescription();
    amount = item.getAmount();
    price = item.getPrice();
    config = item.getConfig();
    category = item.getCategory();
    image = item.getImage();
  }

  public void updateItemEntity(Item item) {
    name = item.getName();
    description = item.getDescription();
    amount = item.getAmount();
    price = item.getPrice();
    config = item.getConfig();
    category = item.getCategory();
    image = item.getImage();
  }

  public ItemsEntity() {

  }
}
