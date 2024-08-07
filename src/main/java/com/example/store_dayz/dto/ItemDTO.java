package com.example.store_dayz.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
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
