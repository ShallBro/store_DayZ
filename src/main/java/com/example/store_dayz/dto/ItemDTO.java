package com.example.store_dayz.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemDTO {
  private Long id;
  private String name;
  private String description;
  private Integer amount;
  @JsonProperty("available_servers")
  private List<String> availableServers;
  private Integer price;
  private String config;
  private String category;
  private String image;
}
