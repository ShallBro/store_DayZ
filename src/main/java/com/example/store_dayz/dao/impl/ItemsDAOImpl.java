package com.example.store_dayz.dao.impl;

import com.example.store_dayz.dao.ItemsDAO;
import com.example.store_dayz.entity.ItemsEntity;
import com.example.store_dayz.model.Item;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ItemsDAOImpl implements ItemsDAO {


  private final Session session;

  @Autowired
  public ItemsDAOImpl(Session session) {
    this.session = session;
  }

  @Override
  public void insertItem(Item item) {
    insert(item);
  }

  private void insert(Item item) {
    ItemsEntity itemsEntity = new ItemsEntity(item);
    try {
      session.beginTransaction();
      session.save(itemsEntity);
      session.getTransaction().commit();
    } finally {
      session.close();
    }
  }

}
