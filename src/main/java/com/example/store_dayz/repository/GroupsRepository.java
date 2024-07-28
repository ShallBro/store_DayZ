package com.example.store_dayz.repository;

import com.example.store_dayz.entity.GroupStalker;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<GroupStalker, Long> {
  Optional<GroupStalker> findGroupStalkerByName(String name);
}
