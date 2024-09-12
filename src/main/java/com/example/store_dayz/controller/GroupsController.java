package com.example.store_dayz.controller;


import com.example.store_dayz.mapper.GroupDtoMapper;
import com.example.types.GroupDTO;
import com.example.store_dayz.entity.InfoGroup;
import com.example.store_dayz.mapper.GenericMapper;
import com.example.types.GroupInfoDTO;
//import com.example.store_dayz.dto.GroupInfoDTO;
import com.example.store_dayz.dto.NameDTO;
import com.example.store_dayz.service.GroupsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restApi/groups")
public class GroupsController {

  private final GroupsService groupsService;

  private final GenericMapper<GroupInfoDTO, InfoGroup> genericMapper;


  @GetMapping("/get")
  public List<GroupDTO> getGroups() {
    return groupsService.getListGroups();
  }

  @PostMapping("/post")
  public GroupInfoDTO getInfoGroup(@RequestBody NameDTO name) {
    return genericMapper.toDto(groupsService.getInfoGroup(name));
  }

}
