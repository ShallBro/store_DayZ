package com.example.store_dayz.service;

import com.example.store_dayz.mapper.GenericMapper;
import com.example.types.GroupDTO;
import com.example.store_dayz.dto.NameDTO;
import com.example.store_dayz.entity.GroupStalker;
import com.example.store_dayz.entity.InfoGroup;
import com.example.store_dayz.exceptions.NotFoundGroupInfo;
import com.example.store_dayz.repository.GroupInfoRepository;
import com.example.store_dayz.repository.GroupsRepository;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GroupsService {

  private final GroupsRepository groupsRepository;

  private final GroupInfoRepository groupInfoRepository;

  private final GenericMapper<GroupDTO, GroupStalker> genericMapper;


  public List<GroupDTO> getListGroups() {
    List<GroupStalker> groupsEntities = groupsRepository.findAll().stream()
      .sorted(Comparator.comparing(GroupStalker::getName))
      .toList();

    return groupsEntities.stream()
      .map(genericMapper::toDto)
      .toList();
  }
  @Transactional
  public InfoGroup getInfoGroup(NameDTO name) {
    InfoGroup infoGroup = groupInfoRepository.findInfoGroupByMotto(name.getName()).orElseThrow(() -> new NotFoundGroupInfo(name.getName()));
    return Hibernate.unproxy(infoGroup, InfoGroup.class);
  }
}
