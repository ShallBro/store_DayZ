package com.example.store_dayz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "items")
public class ItemsEntity {

  private int id;

  private String name;

  private String description;
  private String category;
  private List<String> available_servers;
  private Integer price;
}
