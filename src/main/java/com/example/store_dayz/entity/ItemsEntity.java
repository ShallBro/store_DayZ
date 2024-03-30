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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String description;
  private String category;
  private Integer price;

  @OneToMany(mappedBy = "item")
  private List<AvailableServersEntity> available_servers;

  public ItemsEntity(Item item) {
    name = item.getName();
    description = item.getDescription();
    category = item.getCategory();
    price = item.getPrice();
  }

  public ItemsEntity() {

  }
}
