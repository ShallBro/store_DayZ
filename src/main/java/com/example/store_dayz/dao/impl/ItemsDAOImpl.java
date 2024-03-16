package com.example.store_dayz.dao.impl;

import com.example.store_dayz.dao.ItemsDAO;
import com.example.store_dayz.model.Item;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemsDAOImpl implements ItemsDAO {


  private Session session;

  @Autowired
  public ItemsDAOImpl(Session session) {
    this.session = session;
  }

  @Override
  public void insertItem(Item item) {
    insert(item);
  }

  private void insert(Item item){

  }

}
