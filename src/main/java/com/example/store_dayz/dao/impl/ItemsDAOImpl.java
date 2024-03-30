package com.example.store_dayz.dao.impl;

import com.example.store_dayz.entity.AvailableServersEntity;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.model.Item;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class ItemsDAOImpl {

  private final SessionFactory sessionFactory;

  private final AvailableServersDAOImpl availableServersDAO;

  @Autowired
  public ItemsDAOImpl(SessionFactory sessionFactory, AvailableServersDAOImpl availableServersDAO) {
    this.sessionFactory = sessionFactory;
    this.availableServersDAO = availableServersDAO;
  }

  @Transactional
  public void insertItem(Item item) {
    Session session = sessionFactory.getCurrentSession();
    ItemsEntity itemsEntity = new ItemsEntity(item);
    session.persist(itemsEntity);
    availableServersDAO.insertAvailableServers(itemsEntity.getId(), item);
  }

  @Transactional
  public List<ItemsEntity> selectItems() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("FROM ItemsEntity").getResultList();
  }

  @Transactional
  public List<AvailableServersEntity> getAvailableServersForItem(long idItem) {
    Session session = sessionFactory.getCurrentSession();
    ItemsEntity itemsEntity = session.get(ItemsEntity.class, idItem);
    return itemsEntity.getAvailable_servers();
  }


}
