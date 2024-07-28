package com.example.store_dayz.dao;

import com.example.store_dayz.entity.AvailableServersEntity;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.dto.ItemDTO;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AvailableServersDAOImpl {

  private final SessionFactory sessionFactory;

  @Autowired
  public AvailableServersDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public void insertAvailableServers(ItemDTO itemDTO) {
    itemDTO.getAvailable_servers().forEach(
      availableServer -> {
        Session session = sessionFactory.getCurrentSession();
        ItemsEntity itemsEntity = session.get(ItemsEntity.class, itemDTO.getId());
        AvailableServersEntity availableServersEntity = new AvailableServersEntity(itemsEntity, availableServer);
        session.persist(availableServersEntity);
      }
    );
  }

  public void updateAvailableServers(Session session, ItemsEntity itemsEntity, List<String> newAvailableServers) {
     List<AvailableServersEntity> availableServersCurrent = itemsEntity.getAvailableServers();
     List<AvailableServersEntity> updatedAvailableServers = new ArrayList<>();
     newAvailableServers.forEach(server -> {
       AvailableServersEntity existServer = findServer(itemsEntity.getAvailableServers(), server);
       if (existServer != null) {
         updatedAvailableServers.add(existServer);
       } else {
         AvailableServersEntity newServer = new AvailableServersEntity(itemsEntity, server);
         updatedAvailableServers.add(newServer);
       }
     });
     availableServersCurrent.stream()
       .filter(server -> !updatedAvailableServers.contains(server))
       .forEach(session::remove);
     itemsEntity.setAvailableServers(updatedAvailableServers);
  }

  private AvailableServersEntity findServer(List<AvailableServersEntity> availableServers, String server) {
    return availableServers.stream()
      .filter(availableServer -> availableServer.getName().equals(server))
      .findFirst()
      .orElse(null);
  }
}
