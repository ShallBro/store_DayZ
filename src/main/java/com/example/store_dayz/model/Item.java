package com.example.store_dayz.model;

import java.awt.Image;
import java.util.List;
import lombok.Data;

@Data
public class Item {
  private int id;
  private String name;
  private String description;
  private Image image_path;
  // Отрефакторить поле категория на enum
  private String category;
  private List<String> available_servers;
  private Integer price;

}
