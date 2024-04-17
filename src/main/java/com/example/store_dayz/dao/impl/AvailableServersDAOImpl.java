package com.example.store_dayz.dao.impl;

import com.example.store_dayz.entity.AvailableServersEntity;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
