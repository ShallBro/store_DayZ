package com.example.store_dayz.entity;

import com.example.store_dayz.model.Item;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "items")
public class ItemsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public List<String> getAvailableServers() {
    return availableServers;
  }

  public void setAvailableServers(List<String> availableServers) {
    this.availableServers = availableServers;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  private String name;

  private String description;
  private String category;
  @ElementCollection
  @Column(name = "available_servers")
  private List<String> availableServers;
  private Integer price;

  public ItemsEntity(Item item) {
    name = item.getName();
    description = item.getDescription();
    category = item.getCategory();
    availableServers = item.getAvailable_servers();
    price = item.getPrice();
  }

  public ItemsEntity() {

  }
}
