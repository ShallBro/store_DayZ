package com.example.store_dayz.dao;

import com.example.store_dayz.entity.AvailableServersEntity;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.dto.ItemDTO;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ItemsDAOImpl {

  private final SessionFactory sessionFactory;

  private final AvailableServersDAOImpl availableServersDAO;

  @Autowired
  public ItemsDAOImpl(SessionFactory sessionFactory, AvailableServersDAOImpl availableServersDAO) {
    this.sessionFactory = sessionFactory;
    this.availableServersDAO = availableServersDAO;
  }

  @Transactional
  public void insertItem(ItemDTO itemDTO) {
    Session session = sessionFactory.getCurrentSession();
    ItemsEntity itemsEntity = new ItemsEntity(itemDTO);
    session.persist(itemsEntity);
    availableServersDAO.insertAvailableServers(itemDTO);
  }

  @Transactional
  public void updateItem(ItemDTO itemDTO) {
    Session session = sessionFactory.getCurrentSession();
    ItemsEntity itemsEntity = session.get(ItemsEntity.class, itemDTO.getId());
    itemsEntity.updateItemEntity(itemDTO);
    availableServersDAO.updateAvailableServers(session, itemsEntity, itemDTO.getAvailableServers());
    session.merge(itemsEntity);
  }

  @Transactional
  public void deleteItem(int id) {
    Session session = sessionFactory.getCurrentSession();
    ItemsEntity itemsEntity = session.get(ItemsEntity.class, id);
    session.remove(itemsEntity);
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
    Hibernate.initialize(itemsEntity.getAvailableServers());
    return itemsEntity.getAvailableServers();
  }

}
