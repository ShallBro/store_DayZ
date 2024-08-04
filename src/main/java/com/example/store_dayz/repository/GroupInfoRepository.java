package com.example.store_dayz.repository;

import com.example.store_dayz.entity.InfoGroup;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupInfoRepository extends JpaRepository<InfoGroup, UUID> {
  Optional<InfoGroup> findInfoGroupByMotto(String name);
}
