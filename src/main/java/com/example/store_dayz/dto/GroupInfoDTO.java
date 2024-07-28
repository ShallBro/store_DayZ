package com.example.store_dayz.dto;

import com.example.store_dayz.entity.GroupStalker;
import com.example.store_dayz.entity.InfoGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GroupInfoDTO {
  private String name;
  private String imageUrl;
  private InfoGroup group;
}
