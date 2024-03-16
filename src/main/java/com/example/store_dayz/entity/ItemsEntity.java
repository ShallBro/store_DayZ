package com.example.store_dayz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "items")
public class ItemsEntity {
  @Id
  private int id;

  private String name;

  private String description;
  private String category;
  private List<String> available_servers;
  private Integer price;
}
