package com.example.store_dayz.service;

import com.example.store_dayz.dto.GroupDTO;
import com.example.store_dayz.dto.GroupInfoDTO;
import com.example.store_dayz.dto.NameDTO;
import com.example.store_dayz.entity.GroupStalker;
import com.example.store_dayz.entity.InfoGroup;
import com.example.store_dayz.exceptions.NotFoundGroupInfo;
import com.example.store_dayz.repository.GroupInfoRepository;
import com.example.store_dayz.repository.GroupsRepository;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GroupsService {

  private final GroupsRepository groupsRepository;

  private final GroupInfoRepository groupInfoRepository;


  public List<GroupDTO> getListGroups() {
    List<GroupStalker> groupsEntities = groupsRepository.findAll().stream()
      .sorted(Comparator.comparing(GroupStalker::getName))
      .toList();

    return groupsEntities.stream()
      .map(groupStalker -> new GroupDTO(groupStalker.getName(), groupStalker.getImageUrl(), groupStalker.getPathUrl()))
      .toList();
  }
  @Transactional
  public GroupInfoDTO getInfoGroup(NameDTO name) {
    GroupStalker groupStalker = groupsRepository.findGroupStalkerByPathUrl(name.getName()).orElseThrow(() -> new NotFoundGroupInfo(name.getName()));
    InfoGroup infoGroup = groupInfoRepository.findInfoGroupByMotto(name.getName()).orElseThrow(() -> new NotFoundGroupInfo(name.getName()));
    return GroupInfoDTO.builder()
      .name(groupStalker.getName())
      .imageUrl(groupStalker.getImageUrl())
      .group(infoGroup)
      .build();
  }
}
