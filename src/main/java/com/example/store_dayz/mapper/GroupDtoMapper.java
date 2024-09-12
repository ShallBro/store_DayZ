package com.example.store_dayz.mapper;

import com.example.store_dayz.entity.GroupStalker;
import com.example.store_dayz.entity.InfoGroup;
import com.example.types.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupDtoMapper extends GenericMapper<GroupDTO, GroupStalker> {
  @Override
  @Mapping(target = "name", source = "groupStalker.name")
  @Mapping(target = "imageUrl", source = "groupStalker.imageUrl")
  @Mapping(target = "pathUrl", source = "groupStalker.pathUrl")
  GroupDTO toDto(GroupStalker groupStalker);
}
