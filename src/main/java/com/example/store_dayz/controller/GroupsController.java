package com.example.store_dayz.controller;


import com.example.store_dayz.dto.GroupDTO;
import com.example.store_dayz.dto.GroupInfoDTO;
import com.example.store_dayz.dto.NameDTO;
import com.example.store_dayz.service.GroupsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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


  @GetMapping("/get")
  public List<GroupDTO> getGroups() {
    return groupsService.getListGroups();
  }

  @PostMapping("/post")
  public GroupInfoDTO getInfoGroup(@RequestBody NameDTO name) {
    return groupsService.getInfoGroup(name);
  }

}
