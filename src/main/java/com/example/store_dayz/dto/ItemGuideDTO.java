package com.example.store_dayz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemGuideDTO {
  private String value;
  private String triggerText;
  private String imageURL;
  private String videoID;
}
