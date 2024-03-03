package com.example.store_dayz.model;

import java.awt.Image;
import java.util.List;
import lombok.Data;

@Data
public class Item {
  private String name;
  private String description;
  private String category;
  private List<String> available_servers;
  private Integer price;

}
