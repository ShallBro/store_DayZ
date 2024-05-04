package com.example.store_dayz.dao.impl;

import com.example.store_dayz.entity.AvailableServersEntity;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.model.Item;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AvailableServersDAOImpl {

  private final SessionFactory sessionFactory;

  @Autowired
  public AvailableServersDAOImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Transactional
  public void insertAvailableServers(Item item) {
    item.getAvailable_servers().forEach(
      availableServer -> {
        Session session = sessionFactory.getCurrentSession();
        ItemsEntity itemsEntity = session.get(ItemsEntity.class, item.getId());
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
