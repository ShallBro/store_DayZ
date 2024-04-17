package com.example.store_dayz.model;

import java.util.List;
import lombok.Data;

@Data
public class Item {
  private Long id;
  private String name;
  private String description;
  private Integer amount;
  private List<String> available_servers;
  private Integer price;
  private String config;
  private String category;
  private String image;
}
