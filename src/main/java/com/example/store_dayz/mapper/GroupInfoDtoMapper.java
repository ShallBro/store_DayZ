package com.example.store_dayz.mapper;

import com.example.store_dayz.entity.InfoGroup;
import com.example.types.GroupInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupInfoDtoMapper extends GenericMapper<GroupInfoDTO, InfoGroup> {
  @Override
  @Mapping(target = "name", source = "infoGroup.name")
  @Mapping(target = "founder", source = "infoGroup.founder")
  @Mapping(target = "description", source = "infoGroup.description")
  @Mapping(target = "motto", source = "infoGroup.motto")
  @Mapping(target = "quote", source = "infoGroup.quote")
  @Mapping(target = "goals", source = "infoGroup.goals")
  @Mapping(target = "lifeinside", source = "infoGroup.lifeInside")
  @Mapping(target = "structure", source = "infoGroup.structure")
  @Mapping(target = "image", source = "infoGroup.image")
  @Mapping(target = "caruselImg", source = "infoGroup.caruselImg")
  @Mapping(target = "features", source = "infoGroup.features")
  GroupInfoDTO toDto(InfoGroup infoGroup);
}
